package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.Repositories.PromotionRepository;
import com.example.restaurantappBackend.app.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepositoty) {
        this.promotionRepository = promotionRepositoty;
    }


    @Override
    public Promotion findByPromoID(Integer promoid) {
        return promotionRepository.findPromotionByPromoid(promoid); }


    @Override
    public List<Promotion> findAllpromos() {
        return promotionRepository.findAll();
    }

}
