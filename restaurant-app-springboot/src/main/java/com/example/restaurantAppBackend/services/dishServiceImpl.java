package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.dishRepo;
import com.example.restaurantappBackend.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dishServiceImpl implements dishService {

    @Autowired
    private dishRepo dishRepository;

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish findByDishID(Long dishID) {
        return dishRepository.findById(dishID).orElse(null);
    }

    @Override
    public List<Dish> findDishes(List<Long> dishIDlist) {
        return dishRepository.findAllById(dishIDlist);
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

}
