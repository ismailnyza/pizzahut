package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Topping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ToppingService {
    Topping findTopping(Integer toppingid);
    List<Topping> findAllToppings();
}
