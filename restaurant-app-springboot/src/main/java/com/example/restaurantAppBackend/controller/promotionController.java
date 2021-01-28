package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.model.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class promotionController {
    private final com.example.restaurantappBackend.Repositories.promotionRepo promotionRepo;
    private com.example.restaurantappBackend.services.promotionService promotionService;

    promotionController(com.example.restaurantappBackend.Repositories.promotionRepo promotionRepo) {
        this.promotionRepo = promotionRepo;
    }

    @GetMapping("/service/getAllPromos")
    public ResponseEntity<?> getAllDishes() {
        return ResponseEntity.ok(promotionService.findAllpromos());
    }

    @GetMapping("/service/{PromoID}")
    Promotion tempPromo(@PathVariable String PromoID) {
        return promotionRepo.findById(Long.getLong(PromoID)).orElseThrow();
    }

}
