package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {


    Restaurant findRestaurantByID(Integer restaurantID);

    List<Restaurant> findAllRestaurant();
}
