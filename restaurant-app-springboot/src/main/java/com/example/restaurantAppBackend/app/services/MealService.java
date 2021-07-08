package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Meal;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealService {
    Meal findMeal(Integer dishID);
    List<Meal> findAllDishes();
    List<Meal> saveAllDishes(List<Meal> mealList);
    Page<Meal> paginatedFindAll(int pageNo , int pageSize , String sortType);

}
