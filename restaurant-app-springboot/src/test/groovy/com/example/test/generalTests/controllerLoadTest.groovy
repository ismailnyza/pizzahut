package com.example.test.generalTests

import com.example.restaurantappBackend.app.RestaurantAppBackendApplication
import com.example.restaurantappBackend.app.controller.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

//this is vital
@SpringBootTest(classes = RestaurantAppBackendApplication.class)

class controllerLoadTest extends Specification {

//    testing if all the controllers are loaded
    @Autowired
    private PizzaController pizzaController

    @Autowired
    private MealController mealController

    @Autowired
    private AppetizerController appetizerController

    @Autowired
    private RestaurantController restaurantController

    @Autowired
    private SaleController saleController

    @Autowired
    private PromotionController promotionController

    @Autowired
    private EntreeController entreeController


    def "Appetizer Controller created"() {
        expect: "the WebController is created"
        AppetizerController != null
    }

    def "Entree Controller created"() {
        expect: "the WebController is created"
        EntreeController != null
    }

    def "Meal Controller created"() {
        expect: "the WebController is created"
        MealController != null
    }

    def "Pizza Controller created"() {
        expect: "the WebController is created"
        PizzaController != null
    }

    def "Promotion Controller created"() {
        expect: "the WebController is created"
        PromotionController != null
    }

    def "Restaurant Controller created"() {
        expect: "the WebController is created"
        RestaurantController != null
    }

    def "Sale Controller created"() {
        expect: "the WebController is created"
        SaleController != null
    }


}





