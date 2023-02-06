package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findRestaurantsByRestaurantid(Integer restaurantID);

    @Override
    List<Restaurant> findAll();



}