package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.ToppingRepository;
import com.example.restaurantappBackend.app.model.Topping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {

    private final com.example.restaurantappBackend.app.Repositories.ToppingRepository ToppingRepository;

    public ToppingServiceImpl(ToppingRepository ToppingRepository) {
        this.ToppingRepository = ToppingRepository;
    }

    @Override
    public Topping findTopping(Integer toppingid) {
        return ToppingRepository.findByToppingid(toppingid);
    }

    @Override
    public List<Topping> findAllToppings() {
        return ToppingRepository.findAll();
    }
}
