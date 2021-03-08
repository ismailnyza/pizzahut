package com.example.restaurantappBackend.Repositories;

import com.example.restaurantappBackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale , Integer> {
}
