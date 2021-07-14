package com.example.restaurantappBackend.app.Repositories;

import com.example.restaurantappBackend.app.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale , Integer> {
}
