package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Setter for injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(String title) {
        bookRepository.addBook(title);
    }

    public List<String> getAllBooks() {
        return bookRepository.findAll();
    }
}
