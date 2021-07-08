package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal , Integer> {
    Meal findMealByDishid(Integer dishID);
    @Override
    List<Meal> findAll();
}
