package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load Spring XML context
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the service bean
        BookService service = (BookService) context.getBean("bookService");

        // Use it
        service.addBook("Spring in Action");
    }
}
