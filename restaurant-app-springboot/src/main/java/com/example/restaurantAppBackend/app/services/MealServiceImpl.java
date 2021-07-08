package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.MealRepository;
import com.example.restaurantappBackend.app.model.Meal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal findMeal(Integer dishID) {
       return mealRepository.findMealByDishid(dishID);
    }

    @Override
    public List<Meal> findAllDishes() {
        return mealRepository.findAll();
    }

    @Override
    public List<Meal> saveAllDishes(List<Meal> mealList) {
        return mealRepository.saveAll(mealList);
    }

    @Override
    public Page<Meal> paginatedFindAll(int pageNo, int pageSize, String sortType) {
        Pageable pageable = PageRequest.of(pageNo-1 , pageSize , Sort.by(sortType));
        return this.mealRepository.findAll(pageable);
    }
}
