package com.example.restaurantappBackend.app.services;

import com.example.restaurantappBackend.app.model.Sale;
import org.springframework.stereotype.Service;

@Service
public interface SaleService {
    Sale addSale(Sale sale);
}
