package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.RestaurantRepo;
import com.example.restaurantappBackend.model.Restaurant;
import com.example.restaurantappBackend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestaurantController {

    private final RestaurantRepo restaurantRepo;

    @Autowired
    private RestaurantService restaurantService;

    RestaurantController(RestaurantRepo resturantRepo) {
        this.restaurantRepo = resturantRepo;
    }

    @GetMapping("/service/Restaurant/getAllRestaurants")
    public ResponseEntity<?> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.findAllRestaurant());
    }

    @GetMapping("/service/Restaurant/{RestaurantID}")
    Restaurant getRestaurantByID(@PathVariable Integer RestaurantID) {
        return restaurantRepo.findById(RestaurantID).orElseThrow();
    }

}
