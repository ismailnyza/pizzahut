package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.restaurantRepo;
import com.example.restaurantappBackend.model.Restaurant;

import java.util.List;

public class restaurantServiceImpl implements restaurantService {

    private final restaurantRepo restaurantRepo;

    public restaurantServiceImpl(restaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Restaurant findByrestaurantID(Long restaurantID) {
        return restaurantRepo.findById(restaurantID).orElse(null);
    }

    @Override
    public List<Restaurant> findRestaurants(List<Long> restaurantIDlist) {
        return restaurantRepo.findAllById(restaurantIDlist);
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepo.findAll();
    }
}
