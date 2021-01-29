package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.RestaurantRepo;
import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public Restaurant findRestaurantByID(Integer restaurantID) {
        return restaurantRepo.findRestaurantByRestaurantID(restaurantID);
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepo.findAll();
    }
}
