package com.example.test.controllerTests

import com.example.bookingSystem.app.BookingsystemApplication
import com.example.restaurantappBackend.app.controller.AppetizerController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = BookingsystemApplication.class)
class AppetizerControllerTest extends Specification {

    @Autowired
    private AppetizerController appetizerController


    def "appetizer Controller get dishes by id "(int a) {
        expect: " get all dishes from back end"
        appetizerController.getDishByID(a)
        where:
        a << [1, 2, 10]
    }


}