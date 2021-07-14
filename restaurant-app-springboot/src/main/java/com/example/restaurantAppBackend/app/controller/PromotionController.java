package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.PromotionRepository;
import com.example.restaurantappBackend.app.model.Promotion;
import com.example.restaurantappBackend.app.services.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {

    @Autowired
    private PromotionRepository PromotionRepository;

    @Autowired
    private PromotionServiceImpl promotionService;

    @GetMapping("/service/Promo/getAllPromos")
    public List<Promotion> getAllDishes() {
        return promotionService.findAllpromos();
    }

    @GetMapping("/service/Promo/{PromoID}")
    public Promotion getPromotionByID(@PathVariable Integer PromoID){return  promotionService.findByPromoID(PromoID);}

}
