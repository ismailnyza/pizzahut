package com.example.test.controllerTests

import com.example.bookingSystem.app.BookingsystemApplication
import com.example.restaurantappBackend.app.controller.PizzaController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = BookingsystemApplication.class)

class pizzaControllerTest extends Specification {

    @Autowired
    private PizzaController pizzaController


    def "pizza Controller get all dishes "() {
        expect: " get all dishes from back end"
        pizzaController.getAllDishes()
    }

    def "pizza Controller find dish by ID"(int a) {
        expect: "the expected dish is returned"
        pizzaController.getDishByID(a)

        where:
        a << [1, 2, 10]
    }


}