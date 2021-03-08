package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.DishRepository;
import com.example.restaurantappBackend.model.Dish;
import com.example.restaurantappBackend.services.DishServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
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

    @PostMapping("/service/Dish/UpdateAll")
    public List<Dish> saveAllDishes(@RequestBody List<Dish> allDishes)
    {return  dishService.saveAllDishes(allDishes);}
}
