package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantService {


    Restaurant findRestaurantByID(Integer restaurantID);

    List<Restaurant> findAllRestaurant();
}
