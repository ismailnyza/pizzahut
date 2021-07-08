package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppetizerRepository extends JpaRepository<Appetizer, Integer> {
    Appetizer findAppetizerByDishid(Integer dishid);

    @Override
    List<Appetizer> findAll();
}
