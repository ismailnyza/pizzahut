package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.EntreeRepository;
import com.example.restaurantappBackend.app.model.Entree;
import com.example.restaurantappBackend.app.services.EntreeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntreeController {

    @Autowired
    private EntreeRepository entreeRepository;

    @Autowired
    private EntreeServiceImpl entreeService;

    @GetMapping("/service/Entree/getAllDishes" )
    public List<Entree> getAllDishes() {
        return entreeService.findAlEntrees();
    }


    @GetMapping("/service/Entree/{DishID}")
    public Entree getDishByID(@PathVariable Integer DishID) {
        return entreeService.findEntree(DishID);
    }

    @PostMapping("/service/Entree/UpdateAll")
    public List<Entree> saveAllDishes(@RequestBody List<Entree> allDishes)
    {return  entreeService.saveAllEntrees(allDishes);}

//    pagination code

    @GetMapping ("/service/Entree/Pagination/{pageNo}/{pageSize}/{sortType}")
    public Page<Entree> findPaginated(@PathVariable (value = "pageNo") int pageNo ,@PathVariable (value = "pageSize") int pageSize ,@PathVariable (value = "sortType") String sortType ,   Model model) {

        Page<Entree> page = entreeService.paginatedFindAll(pageNo , pageSize , sortType);
        List<Entree> entreeList = page.getContent();

        model.addAttribute("currentpage" ,pageNo);
        model.addAttribute("totalPages" , page.getTotalPages());
        model.addAttribute("totalItems" , page.getTotalElements());
        model.addAttribute("listEntree" , entreeList);
        return page;
    }

    //    update single pizza
    @PostMapping("service/Entree/update")
    public void updateEntree(@RequestBody Entree entree){
        entreeRepository.save(entree);
        System.out.println("Dish updated");
    }
}
