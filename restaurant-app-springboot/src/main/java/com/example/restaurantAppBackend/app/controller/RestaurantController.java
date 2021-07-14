package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.RestaurantRepository;
import com.example.restaurantappBackend.app.model.Restaurant;
import com.example.restaurantappBackend.app.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @GetMapping("/service/Restaurant/getAllRestaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAllRestaurant();
    }

    @GetMapping("/service/Restaurant/{RestaurantID}")
    Restaurant getRestaurantByID(@PathVariable Integer RestaurantID) {
        return restaurantService.findRestaurantByID(RestaurantID);
    }

}
