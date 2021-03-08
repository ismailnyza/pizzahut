package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.PromotionRepository;
import com.example.restaurantappBackend.model.Promotion;
import com.example.restaurantappBackend.services.PromotionServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
class PromotionController {
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
