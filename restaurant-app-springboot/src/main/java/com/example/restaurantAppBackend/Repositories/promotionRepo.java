package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepo extends JpaRepository<Promotion, Long> {

    Promotion findPromotionByPromoID(Integer promoID);

    @Override
    List<Promotion> findAll();


}
