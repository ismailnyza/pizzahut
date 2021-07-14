package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.PizzaRepository;
import com.example.restaurantappBackend.app.model.Pizza;
import com.example.restaurantappBackend.app.services.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//idea controller class
@RestController
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaServiceImpl pizzaService;

    @GetMapping("/service/pizza/getAllDishes" )
    public List<Pizza> getAllDishes() {
        return pizzaService.findAllDishes();
    }



    @GetMapping("/service/Pizza/{DishID}")
    public Pizza getDishByID(@PathVariable Integer DishID) {
        return pizzaService.findPizza(DishID);
    }

//    pagination code

    @GetMapping ("/service/Pizza/Pagination/{pageNo}/{pageSize}/{sortType}")
    public Page<Pizza> findPaginated(@PathVariable (value = "pageNo") String pageNo , @PathVariable (value = "pageSize") String pageSize , @PathVariable (value = "sortType") String sortType , Model model) {

        Page<Pizza> page = pizzaService.paginatedFindAll(pageNo , pageSize , sortType);
        List<Pizza> pizzaList = page.getContent();
        sortType = "dishid";

        model.addAttribute("currentpage" ,pageNo);
        model.addAttribute("totalPages" , page.getTotalPages());
        model.addAttribute("totalItems" , page.getTotalElements());
        model.addAttribute("listPizza" , pizzaList);
        return  page;
    }

//    update single pizza
    @PostMapping("service/Pizza/update")
    public void updatePizza(@RequestBody Pizza pizza){
        pizzaRepository.save(pizza);
        System.out.println("Dish updated");
    }

    @PostMapping("service/Pizza/delete/{dishID}")
    public void deletePizza(@PathVariable (value = "dishID") Integer dishID){
        pizzaRepository.deleteById(dishID);
    }


}
