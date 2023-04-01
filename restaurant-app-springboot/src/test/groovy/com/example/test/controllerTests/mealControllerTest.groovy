package com.example.test.controllerTests

import com.example.bookingSystem.app.BookingsystemApplication
import com.example.restaurantappBackend.app.controller.MealController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = BookingsystemApplication.class)


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