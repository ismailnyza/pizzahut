package com.example.restaurantappBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestaurantappBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantappBackendApplication.class, args);
        System.out.println("connection established");
    }
}
