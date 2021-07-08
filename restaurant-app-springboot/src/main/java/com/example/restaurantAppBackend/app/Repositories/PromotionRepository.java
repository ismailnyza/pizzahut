package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Promotion findPromotionByPromoid(Integer promoid);

    @Override
    List<Promotion> findAll();


}
