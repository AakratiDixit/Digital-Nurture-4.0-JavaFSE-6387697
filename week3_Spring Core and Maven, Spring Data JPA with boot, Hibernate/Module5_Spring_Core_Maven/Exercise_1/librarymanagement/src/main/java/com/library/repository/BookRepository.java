package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
        System.out.println("Added book: " + title);
    }

    public List<String> findAll() {
        return books;
    }
}
