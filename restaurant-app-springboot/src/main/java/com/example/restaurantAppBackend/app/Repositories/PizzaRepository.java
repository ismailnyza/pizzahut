package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    Pizza findPizzaByDishid(Integer dishID);
    @Override
    List<Pizza> findAll();
}
