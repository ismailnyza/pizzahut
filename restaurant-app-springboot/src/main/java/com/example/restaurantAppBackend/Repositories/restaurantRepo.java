package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface restaurantRepo extends JpaRepository<Restaurant, Long> {

    @Override
    Optional<Restaurant> findById(Long restaurantID);

    @Override
    List<Restaurant> findAll();

}
