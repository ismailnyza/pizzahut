package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

    Restaurant findRestaurantByRestaurantID(Integer restaurantID);

    @Override
    List<Restaurant> findAll();

}
