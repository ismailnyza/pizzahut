package com.example.test.controllerTests

import com.example.restaurantappBackend.app.RestaurantAppBackendApplication
import com.example.restaurantappBackend.app.controller.EntreeController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = RestaurantAppBackendApplication.class)

class EntreeControllerTest extends Specification {

    @Autowired
    private EntreeController entreeController

    def "get Entree by dish id"() {
        expect: " get all dishes from back end"
        entreeController.getDishByID(a)
        where:
        a << [1, 2, 10]
    }

}