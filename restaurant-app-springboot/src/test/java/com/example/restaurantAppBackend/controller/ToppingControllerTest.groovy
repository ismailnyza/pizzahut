package com.example.restaurantappBackend.controller

import com.example.restaurantappBackend.Repositories.ToppingRepository
import com.example.restaurantappBackend.model.Topping
import com.example.restaurantappBackend.services.ToppingServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ToppingControllerTest extends Specification {
    @Mock
    ToppingRepository ToppingRepository
    @Mock
    ToppingServiceImpl ToppingService
    @InjectMocks
    ToppingController toppingController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test get All Toppings"() {
        given:
        when(ToppingService.findAllToppings()).thenReturn([new Topping(0, "toppingname", 0)])

        when:
        List<Topping> result = toppingController.getAllToppings()

        then:
        result == [new Topping(0, "toppingname", 0)]
    }

    def "test get Topping By ID"() {
        given:
        when(ToppingService.findTopping(anyInt())).thenReturn(new Topping(0, "toppingname", 0))

        when:
        Topping result = toppingController.getToppingByID(0)

        then:
        result == new Topping(0, "toppingname", 0)
    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme