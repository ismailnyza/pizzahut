package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PizzaService {
    Pizza findPizza(Integer dishID);
    List<Pizza> findAllDishes();
    List<Pizza> saveAllDishes(List<Pizza> pizzaList);
    Page<Pizza> paginatedFindAll(String pageNo , String pageSize , String sortType);

}
