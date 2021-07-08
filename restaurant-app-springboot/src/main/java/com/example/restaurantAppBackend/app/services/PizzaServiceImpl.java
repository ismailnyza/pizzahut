package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.PizzaRepository;
import com.example.restaurantappBackend.app.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{

    @Autowired
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza findPizza(Integer dishID) {
        return pizzaRepository.findPizzaByDishid(dishID);
    }

    @Override
    public List<Pizza> findAllDishes() {
        return pizzaRepository.findAll();
    }

    @Override
    public List<Pizza> saveAllDishes(List<Pizza> pizzaList) {
        return (List<Pizza>) pizzaRepository.saveAll(pizzaList);
    }

    @Override
//    implement sort as well
    public Page<Pizza> paginatedFindAll(String pageNo, String pageSize , String sortType) {
        Pageable pageable = PageRequest.of( Integer.valueOf(pageNo)-1 , Integer.parseInt(pageSize), Sort.by(sortType));
        return this.pizzaRepository.findAll(pageable);
    }

    public void deletePizza(Integer dishID){
        pizzaRepository.deleteById(dishID);
    }




}
