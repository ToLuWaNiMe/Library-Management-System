# Library Management System

This project is a Library Management System API built with Spring Boot.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- H2 Database (default) or MySQL/PostgreSQL

## Getting Started

1.Clone the repository:

git clone https://github.com/your-repo/library-management-system.git

2.Navigate to the project directory:

cd library-management-system

3.Configure the database settings in src/main/resources/application.properties.

4.Build and run the application:

mvn spring-boot:run
Access the API at http://localhost:8080.
API Endpoints
GET /api/books: Retrieve a list of all books.
GET /api/books/{id}: Retrieve details of a specific book by ID.
POST /api/books: Add a new book to the library.
PUT /api/books/{id}: Update an existing book's information.
DELETE /api/books/{id}: Remove a book from the library.
GET /api/patrons: Retrieve a list of all patrons.
GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
POST /api/patrons: Add a new patron to the system.
PUT /api/patrons/{id}: Update an existing patron's information.
DELETE /api/patrons/{id}: Remove a patron from the system.
POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.

5.Testing
To run the tests:
mvn test

6.Documentation
Access the API documentation at http://localhost:8080/swagger-ui/.
