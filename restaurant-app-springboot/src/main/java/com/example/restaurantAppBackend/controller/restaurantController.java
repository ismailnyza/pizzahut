package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class restaurantController {

    private final com.example.restaurantappBackend.Repositories.restaurantRepo restaurantRepo;

    @Autowired
    private com.example.restaurantappBackend.services.restaurantService restaurantService;

    restaurantController(com.example.restaurantappBackend.Repositories.restaurantRepo resturantRepo) {
        this.restaurantRepo = resturantRepo;
    }

    @GetMapping("/service/getAllRestaurants")
    public ResponseEntity<?> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.findAllRestaurant());
    }

    @GetMapping("/service/{RestaurantID}")
    Restaurant temprestaurant(@PathVariable String RestaurantID) {
        return restaurantRepo.findById(Long.getLong(RestaurantID)).orElseThrow();
    }

    //        test
}
