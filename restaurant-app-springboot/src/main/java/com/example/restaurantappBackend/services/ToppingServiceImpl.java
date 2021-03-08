package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.ToppingRepository;
import com.example.restaurantappBackend.model.Topping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {

    private final ToppingRepository ToppingRepository;

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
