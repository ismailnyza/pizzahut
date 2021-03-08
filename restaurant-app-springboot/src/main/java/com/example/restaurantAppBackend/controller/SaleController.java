package com.example.restaurantappBackend.controller;

import com.example.restaurantappBackend.Repositories.SaleRepository;
import com.example.restaurantappBackend.model.Sale;
import com.example.restaurantappBackend.services.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleServiceImpl saleService;

    @RequestMapping(value = "/service/sale" , method = RequestMethod.POST)
    @ResponseBody
    public void addSale(@RequestBody Sale sale){
        System.out.println(sale);
        saleService.addSale(sale);
    }

}
