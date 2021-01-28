package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Promotion;

import java.util.List;

public interface promotionService {

    Promotion save(Promotion promotion);

    Promotion findBypromoID(Long promoID);

    List<Promotion> findpromos(List<Long> promoIDlist);

    List<Promotion> findAllpromos();
}
