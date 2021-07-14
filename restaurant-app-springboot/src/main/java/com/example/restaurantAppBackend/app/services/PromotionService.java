package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {


    Promotion findByPromoID(Integer promoid);

    List<Promotion> findAllpromos();
}
