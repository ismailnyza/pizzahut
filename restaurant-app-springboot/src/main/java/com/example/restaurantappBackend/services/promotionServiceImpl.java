package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.PromotionRepository;
import com.example.restaurantappBackend.model.Promotion;
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
