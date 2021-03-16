package com.example.restaurantappBackend.controller

import com.example.restaurantappBackend.Repositories.DishRepository
import com.example.restaurantappBackend.model.Dish
import com.example.restaurantappBackend.services.DishServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class DishControllerTest extends Specification {
    @Mock
    DishRepository DishRepository
    @Mock
    DishServiceImpl dishService
    @InjectMocks
    DishController dishController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test get All Dishes"() {
        given:
        when(dishService.findAllDishes()).thenReturn([new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")])

        when:
        List<Dish> result = dishController.getAllDishes()

        then:
        result == [new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")]
    }

    def "test get Dish By ID"() {
        given:
        when(dishService.findDishes(anyInt())).thenReturn(new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice"))

        when:
        Dish result = dishController.getDishByID(0)

        then:
        result == new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")
    }

    def "test save All Dishes"() {
        given:
        when(dishService.saveAllDishes(any())).thenReturn([new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")])

        when:
        List<Dish> result = dishController.saveAllDishes([new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")])

        then:
        result == [new Dish(0, "dishname", "dishdesc", "dishimg", "dishprice")]
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme