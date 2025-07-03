package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.library.config.AppConfig;
import com.example.library.service.LibraryService;

/**
 * Main Application Class for Library Management System
 * This demonstrates Spring Framework integration
 */
public class App
{
    public static void main( String[] args )
    {
        // Create Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the LibraryService bean from Spring context
        LibraryService libraryService = context.getBean(LibraryService.class);

        // Test the service
        System.out.println(libraryService.getApplicationInfo());
        System.out.println(libraryService.addBook("Java Programming"));
        System.out.println(libraryService.addBook("Spring Framework Guide"));

        System.out.println("\nSpring Framework is working correctly!");
        System.out.println("All dependencies are properly configured!");
    }
}
