package com.example.library;

public class BookService {
    
    private BookRepository bookRepository;

    // **Setter for DI**
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String book) {
        bookRepository.save(book);
    }
    
}
