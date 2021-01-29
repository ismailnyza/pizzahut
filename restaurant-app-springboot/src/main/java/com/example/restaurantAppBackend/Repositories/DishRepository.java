package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    Dish findDishByDishid(Integer dishid);

    @Override
    List<Dish> findAll();


}
