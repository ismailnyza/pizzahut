package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Topping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public interface ToppingService {
    Topping findTopping(Integer toppingid);
    List<Topping> findAllToppings();
}
