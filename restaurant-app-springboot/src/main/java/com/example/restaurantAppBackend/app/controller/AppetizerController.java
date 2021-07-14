package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.AppetizerRepository;
import com.example.restaurantappBackend.app.model.Appetizer;
import com.example.restaurantappBackend.app.services.AppetizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppetizerController {

    @Autowired
    private AppetizerRepository appetizerRepository;

    @Autowired
    private AppetizerServiceImpl appetizerService;

    @GetMapping("/service/Appetizer/getAllDishes")
    public List<Appetizer> getAllDishes() {
        return appetizerService.findAllAppetizers();
    }


    @GetMapping("/service/Appetizer/{DishID}")
    public Appetizer getDishByID(@PathVariable Integer DishID) {
        return appetizerService.findAppetizer(DishID);
    }

    @PostMapping("/service/Appetizer/UpdateAll")
    public List<Appetizer> saveAllDishes(@RequestBody List<Appetizer> allDishes) {
        return appetizerService.saveAllAppetizer(allDishes);
    }

//    pagination code

    @GetMapping("/service/Appetizer/Pagination/{pageNo}/{pageSize}/{sortType}")
    public Page<Appetizer> findPaginated(@PathVariable(value = "pageNo") int pageNo, @PathVariable(value = "pageSize") int pageSize, @PathVariable(value = "sortType") String sortType, Model model) {

        Page<Appetizer> page = appetizerService.paginatedFindAll(pageNo, pageSize, sortType);
        List<Appetizer> appetizerList = page.getContent();

        model.addAttribute("currentpage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAppetizer", appetizerList);
        return page;
    }

    //    update single pizza
    @PostMapping("service/Appetizer/update")
    public void updatePizza(@RequestBody Appetizer appetizer){
        appetizerRepository.save(appetizer);
        System.out.println("Dish updated");
    }
}
