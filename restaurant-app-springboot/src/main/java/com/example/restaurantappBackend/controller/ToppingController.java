package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.ToppingRepository;
import com.example.restaurantappBackend.model.Topping;
import com.example.restaurantappBackend.services.ToppingServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
class ToppingController {
    @Autowired
    private ToppingRepository ToppingRepository;

    @Autowired
    private ToppingServiceImpl ToppingService;

    @GetMapping("/service/Topping/getAllToppings")
    public List<Topping> getAllToppings() {
        return ToppingService.findAllToppings();
    }

    @GetMapping("/service/Topping/{ToppingID}")
    public Topping getToppingByID(@PathVariable Integer ToppingID) {
        return ToppingService.findTopping(ToppingID);
    }
}
