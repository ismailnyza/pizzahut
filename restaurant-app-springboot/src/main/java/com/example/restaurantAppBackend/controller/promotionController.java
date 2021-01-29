package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.PromotionRepo;
import com.example.restaurantappBackend.model.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PromotionController {
    private final PromotionRepo promotionRepo;
    private com.example.restaurantappBackend.services.PromotionService promotionService;

    PromotionController(PromotionRepo promotionRepo) {
        this.promotionRepo = promotionRepo;
    }

    @GetMapping("/service/Promo/getAllPromos")
    public ResponseEntity<?> getAllDishes() {
        return ResponseEntity.ok(promotionService.findAllpromos());
    }

    @GetMapping("/service/Promo/{PromoID}")
    Promotion tempPromo(@PathVariable String PromoID) {
        return promotionRepo.findById(Long.getLong(PromoID)).orElseThrow();
    }

}
