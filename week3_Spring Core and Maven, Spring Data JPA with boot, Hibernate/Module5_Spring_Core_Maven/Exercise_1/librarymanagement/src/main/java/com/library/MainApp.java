package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        //Spring container building
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");

            //Spring gave ready object
            BookService bookService = (BookService) context.getBean("bookService");

        // use it now - dependecies have alreadt been created
        bookService.createBook("The Alchemist");
        bookService.createBook("Clean Code");

        System.out.println("All Books: " + bookService.getAllBooks());

        ((ClassPathXmlApplicationContext) context).close();
    }
}