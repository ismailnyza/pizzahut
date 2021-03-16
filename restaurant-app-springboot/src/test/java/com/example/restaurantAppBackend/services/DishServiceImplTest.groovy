package com.example.restaurantappBackend.services

import com.example.restaurantappBackend.Repositories.DishRepository
import com.example.restaurantappBackend.model.Dish
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class DishServiceImplTest extends Specification {
    @Mock
    DishRepository dishRepository
    @InjectMocks
    DishServiceImpl dishServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find Dishes"() {
        given:
        when(dishRepository.findDishByDishid(anyInt())).thenReturn(new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice"))

        when:
        Dish result = dishServiceImpl.findDishes(0)

        then:
        result == new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")
    }

    def "test find All Dishes"() {
        given:
        when(dishRepository.findAll()).thenReturn([new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")])

        when:
        List<Dish> result = dishServiceImpl.findAllDishes()

        then:
        result == [new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")]
    }

    def  "test save All Dishes"() {
        when:
        List<Dish> result = dishServiceImpl.saveAllDishes([new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")])

        then:
        result == [new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")]
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme