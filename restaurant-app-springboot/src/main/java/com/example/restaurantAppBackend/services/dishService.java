package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Dish;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DishService {
    Dish findDishes(Integer dishIDList);
    List<Dish> findAllDishes();
}
