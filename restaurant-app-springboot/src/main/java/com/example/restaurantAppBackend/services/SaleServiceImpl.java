package com.example.restaurantappBackend.services;

import com.example.restaurantappBackend.Repositories.SaleRepository;
import com.example.restaurantappBackend.model.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements  SaleService{

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    public Sale addSale(Sale sale){
        System.out.println(sale);
         saleRepository.save(sale);
         return sale;
    }
}
