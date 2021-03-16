package com.example.restaurantappBackend.services

import com.example.restaurantappBackend.Repositories.ToppingRepository
import com.example.restaurantappBackend.model.Topping
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ToppingServiceImplTest extends Specification {
    @Mock
    ToppingRepository ToppingRepository
    @InjectMocks
    ToppingServiceImpl toppingServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find Topping"() {
        given:
        when(ToppingRepository.findByToppingid(anyInt())).thenReturn(new Topping(0, "toppingname", 0))

        when:
        Topping result = toppingServiceImpl.findTopping(0)

        then:
        result == new Topping(0, "toppingname", 0)
    }

    def "test find All Toppings"() {
        given:
        when(ToppingRepository.findAll()).thenReturn([new Topping(0, "toppingname", 0)])

        when:
        List<Topping> result = toppingServiceImpl.findAllToppings()

        then:
        result == [new Topping(0, "toppingname", 0)]
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme