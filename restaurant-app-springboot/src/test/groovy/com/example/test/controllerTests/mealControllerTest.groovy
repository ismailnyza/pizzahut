package com.example.test.controllerTests

import com.example.restaurantappBackend.app.RestaurantAppBackendApplication
import com.example.restaurantappBackend.app.controller.MealController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = RestaurantAppBackendApplication.class)


class mealControllerTest extends Specification {


    @Autowired
    private MealController mealController

    def "get Entree by dish id"() {
        expect: " get all dishes from back end"
        mealController.getDishByID(a)
        where:
        a << [1, 2, 10]
    }
}