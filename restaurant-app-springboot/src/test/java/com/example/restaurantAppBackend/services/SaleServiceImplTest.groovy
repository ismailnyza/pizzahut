package com.example.restaurantappBackend.services

import com.example.restaurantappBackend.Repositories.SaleRepository
import com.example.restaurantappBackend.model.Sale
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import spock.lang.Specification

class SaleServiceImplTest extends Specification {
    @Mock
    SaleRepository saleRepository
    @InjectMocks
    SaleServiceImpl saleServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test add Sale"() {
        when:
        Sale result = saleServiceImpl.addSale(new Sale(0, "purchasedcart", 0, "purchasedtime"))

        then:
        result == new Sale(0, "purchasedcart", 0, "purchasedtime")
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme