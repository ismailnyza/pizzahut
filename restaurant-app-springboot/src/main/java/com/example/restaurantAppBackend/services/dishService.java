package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Dish;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface dishService {
    Dish save(Dish dish);

    Dish findByDishID(Long dishID);

    List<Dish> findDishes(List<Long> dishIDlist);

    List<Dish> findAllDishes();
}
