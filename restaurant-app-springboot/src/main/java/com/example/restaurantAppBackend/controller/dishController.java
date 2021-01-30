package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.DishRepository;
import com.example.restaurantappBackend.model.Dish;
import com.example.restaurantappBackend.services.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
class DishController {
    @Autowired
    private DishRepository DishRepository;

    @Autowired
    private DishServiceImpl dishService;


    @GetMapping("/service/Dish/getAllDishes")
    public List<Dish> getAllDishes() {
        return dishService.findAllDishes();
    }

    @GetMapping("/service/Dish/{DishID}")
    public Dish getDishByID(@PathVariable Integer DishID) {
        return dishService.findDishes(DishID);
    }


}
