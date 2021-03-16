package com.example.restaurantappBackend.controller

import com.example.restaurantappBackend.Repositories.SaleRepository
import com.example.restaurantappBackend.model.Sale
import com.example.restaurantappBackend.services.SaleServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class SaleControllerTest extends Specification {
    @Mock
    SaleRepository saleRepository
    @Mock
    SaleServiceImpl saleService
    @InjectMocks
    SaleController saleController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test add Sale"() {
        given:
        when(saleService.addSale(any())).thenReturn(new Sale(0, "purchasedcart", 0, "purchasedtime"))

        when:
        saleController.addSale(new Sale(0, "purchasedcart", 0, "purchasedtime"))

        then:
        false//todo - validate something
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme