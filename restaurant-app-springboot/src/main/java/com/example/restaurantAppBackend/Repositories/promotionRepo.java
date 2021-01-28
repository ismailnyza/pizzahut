package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface promotionRepo extends JpaRepository<Promotion, Long> {

    @Override
    Optional<Promotion> findById(Long promoID);

    @Override
    List<Promotion> findAll();


}
