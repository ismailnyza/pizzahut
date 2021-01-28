package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.promotionRepo;
import com.example.restaurantappBackend.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class promotionServiceImpl implements promotionService {

    @Autowired
    private promotionRepo promotionRepositoty;


    @Override
    public Promotion save(Promotion promotion) {
        return promotionRepositoty.save(promotion);
    }


    @Override
    public Promotion findBypromoID(Long promoID) {
        return promotionRepositoty.findById(promoID).orElse(null);
    }

    @Override
    public List<Promotion> findpromos(List<Long> promoIDlist) {
        return promotionRepositoty.findAllById(promoIDlist);
    }

    @Override
    public List<Promotion> findAllpromos() {
        return promotionRepositoty.findAll();
    }

}
