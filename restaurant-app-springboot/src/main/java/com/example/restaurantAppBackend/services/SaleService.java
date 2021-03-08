package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.model.Sale;
import org.springframework.stereotype.Component;

@Component
public interface SaleService {
    Sale addSale(Sale sale);
}
