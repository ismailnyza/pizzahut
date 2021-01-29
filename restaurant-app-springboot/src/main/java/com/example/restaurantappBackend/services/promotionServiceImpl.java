package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.PromotionRepo;
import com.example.restaurantappBackend.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepo promotionRepositoty;

    public PromotionServiceImpl(PromotionRepo promotionRepositoty) {
        this.promotionRepositoty = promotionRepositoty;
    }


    @Override
    public Promotion findByPromoID(Integer promoID) {
        return promotionRepositoty.findPromotionByPromoID(promoID);
    }

    @Override
    public List<Promotion> findAllpromos() {
        return promotionRepositoty.findAll();
    }

}
