package com.example.bookingSystem.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

@RestController
public class BookingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsystemApplication.class, args);
        System.out.println("Back End Is online");
    }



    }
