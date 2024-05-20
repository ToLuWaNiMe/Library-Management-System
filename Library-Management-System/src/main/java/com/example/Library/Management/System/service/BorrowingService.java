package com.example.Library.Management.System.service;

import com.example.Library.Management.System.exception.ResourceNotFoundException;
import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.model.BorrowingRecord;
import com.example.Library.Management.System.model.Patron;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.BorrowingRecordRepository;
import com.example.Library.Management.System.repository.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new ResourceNotFoundException("Patron not found"));

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());

        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findById(bookId)
                .filter(record -> record.getPatron().getId().equals(patronId))
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found"));

        borrowingRecord.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }
}

