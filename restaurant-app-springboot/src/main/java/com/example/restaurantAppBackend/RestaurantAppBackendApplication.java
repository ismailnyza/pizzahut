package com.example.restaurantappBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class    RestaurantAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantAppBackendApplication.class, args);
    }


        public WebMvcConfigurer corsConfigurer(){
            return new WebMvcConfigurer(){
                @Override
                public  void  addCorsMappings(CorsRegistry registry){
                    registry.addMapping("/**").allowedOrigins("*");
                }
            };
        }
    }
