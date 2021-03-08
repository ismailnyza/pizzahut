package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.RestaurantRepository;
import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant findRestaurantByID(Integer restaurantID) {
        return restaurantRepository.findRestaurantsByRestaurantid(restaurantID);
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
