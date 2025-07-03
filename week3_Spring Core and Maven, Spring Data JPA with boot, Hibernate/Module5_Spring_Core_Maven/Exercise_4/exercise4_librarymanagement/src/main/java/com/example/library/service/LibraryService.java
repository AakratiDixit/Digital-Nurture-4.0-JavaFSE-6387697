package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Library Service Class
 * This demonstrates Spring's dependency injection and component scanning
 */
@Service
public class LibraryService {
    
    @Autowired
    private String applicationName;
    
    /**
     * Method to get application information
     * @return String containing application info
     */
    public String getApplicationInfo() {
        return "Welcome to " + applicationName + "!";
    }
    
    /**
     * Example method for library operations
     * @param bookTitle the title of the book
     * @return confirmation message
     */
    
    public String addBook(String bookTitle) {
        return "Book '" + bookTitle + "' has been added to the library.";
    }
}
