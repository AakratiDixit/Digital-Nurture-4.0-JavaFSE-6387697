package com.example.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.example.jpa")
public class JpaHibernateComparisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateComparisonApplication.class, args);
    }
}
