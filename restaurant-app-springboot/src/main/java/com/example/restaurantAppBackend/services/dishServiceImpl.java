package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.DishRepository;
import com.example.restaurantappBackend.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    @Override
    public Dish findDishes(Integer dishID) {
        return dishRepository.findDishByDishid(dishID);
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

}
