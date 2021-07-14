package com.example.restaurantappBackend.app.controller;

import com.example.restaurantappBackend.app.Repositories.SaleRepository;
import com.example.restaurantappBackend.app.model.Sale;
import com.example.restaurantappBackend.app.services.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleServiceImpl saleService;

    @RequestMapping(value = "/service/sale", method = RequestMethod.POST)
    @ResponseBody
    public void addSale(@RequestBody Sale sale) {
        System.out.println(sale);
        saleService.addSale(sale);
    }

}
