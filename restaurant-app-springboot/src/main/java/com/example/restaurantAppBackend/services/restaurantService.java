package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Restaurant;

import java.util.List;

public interface restaurantService {

    Restaurant save(Restaurant restaurant);

    Restaurant findByrestaurantID(Long restaurantID);

    List<Restaurant> findRestaurants(List<Long> restaurantIDlist);

    List<Restaurant> findAllRestaurant();
}
