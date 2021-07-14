package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.model.Topping;
import com.example.restaurantappBackend.app.services.ToppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ToppingController {
    @Autowired
    private com.example.restaurantappBackend.app.Repositories.ToppingRepository ToppingRepository;

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
