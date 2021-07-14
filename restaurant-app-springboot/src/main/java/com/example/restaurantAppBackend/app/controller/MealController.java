package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.MealRepository;
import com.example.restaurantappBackend.app.model.Meal;
import com.example.restaurantappBackend.app.services.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private MealServiceImpl mealService;

    @GetMapping("/service/Meal/getAllDishes" )
    public List<Meal> getAllDishes() {
        return mealService.findAllDishes();
    }


    @GetMapping("/service/Meal/{DishID}")
    public Meal getDishByID(@PathVariable Integer DishID) {
        return mealService.findMeal(DishID);
    }

    @PostMapping("/service/Meal/UpdateAll")
    public List<Meal> saveAllDishes(@RequestBody List<Meal> allDishes)
    {return  mealService.saveAllDishes(allDishes);}

//    pagination code

    @GetMapping ("/service/Meal/Pagination/{pageNo}/{pageSize}/{sortType}")
    public Page<Meal> findPaginated(@PathVariable (value = "pageNo") int pageNo ,@PathVariable (value = "pageSize") int pageSize ,@PathVariable (value = "sortType") String sortType ,   Model model) {

        Page<Meal> page = mealService.paginatedFindAll(pageNo , pageSize , sortType);
        List<Meal> mealList = page.getContent();

        model.addAttribute("currentpage" ,pageNo);
        model.addAttribute("totalPages" , page.getTotalPages());
        model.addAttribute("totalItems" , page.getTotalElements());
        model.addAttribute("listMeal" , mealList);
        return page;
    }

    //    update single pizza
    @PostMapping("service/Meal/update")
    public void updateEntree(@RequestBody Meal meal){
        mealRepository.save(meal);
        System.out.println("Dish updated");
    }



}
