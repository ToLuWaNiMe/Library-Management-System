package com.example.Library.Management.System.service;

import com.example.Library.Management.System.model.Book;
import com.example.Library.Management.System.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        List<Book> books = Collections.singletonList(book);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
    }

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setTitle("New Book");
        book.setAuthor("New Author");

        Mockito.when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.addBook(book);
        assertEquals("New Book", result.getTitle());
    }

    // Add more tests for other methods
}
