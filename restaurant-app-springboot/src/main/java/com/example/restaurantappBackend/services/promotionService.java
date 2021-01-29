package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Promotion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PromotionService {


    Promotion findByPromoID(Integer promoID);

    List<Promotion> findAllpromos();
}
