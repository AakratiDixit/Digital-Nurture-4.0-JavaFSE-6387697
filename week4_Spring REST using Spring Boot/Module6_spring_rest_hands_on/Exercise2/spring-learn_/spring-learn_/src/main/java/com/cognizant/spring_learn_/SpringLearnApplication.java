package com.cognizant.spring_learn_;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
        // Start Spring Boot application
        SpringApplication.run(SpringLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.debug("START run()");
        displayCountry();
        LOGGER.debug("END run()");
	}

	    public static void displayCountry() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country.toString());
        }
    }


}
