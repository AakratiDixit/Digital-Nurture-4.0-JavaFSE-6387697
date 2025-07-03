package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Configuration Class for Library Management Application
 * This class demonstrates that Spring Context dependency is working
 */
@Configuration
@ComponentScan(basePackages = "com.example.library")
public class AppConfig {
    
    /**
     * Example bean definition
     * This shows how to define beans in Spring configuration
     */
    @Bean
    public String applicationName() {
        return "Library Management System";
    }
}
