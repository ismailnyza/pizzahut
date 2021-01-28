package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.dishRepo;
import com.example.restaurantappBackend.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dishController {
    private final dishRepo dishRepo;

    @Autowired
    private com.example.restaurantappBackend.services.dishService dishService;

    dishController(com.example.restaurantappBackend.Repositories.dishRepo dishRepo, com.example.restaurantappBackend.services.dishService dishService) {
        this.dishRepo = dishRepo;
    }

    @GetMapping("/service/getAllDishes")
    public ResponseEntity<?> getAllDishes() {
        return ResponseEntity.ok(dishService.findAllDishes());
    }

    @GetMapping("/service/{DishID}")
    Dish tempdish(@PathVariable String DishID) {
        return dishRepo.findById(Long.getLong(DishID)).orElseThrow();
    }

    //        test
    @GetMapping("/service/test")
    public String test() {
        return ("works");
    }


}
