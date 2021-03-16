package com.example.restaurantappBackend.controller

import com.example.restaurantappBackend.Repositories.RestaurantRepository
import com.example.restaurantappBackend.model.Restaurant
import com.example.restaurantappBackend.services.RestaurantServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class RestaurantControllerTest extends Specification {
    @Mock
    RestaurantRepository restaurantRepository
    @Mock
    RestaurantServiceImpl restaurantService
    @InjectMocks
    RestaurantController restaurantController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test get All Restaurants"() {
        given:
        when(restaurantService.findAllRestaurant()).thenReturn([new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")])

        when:
        List<Restaurant> result = restaurantController.getAllRestaurants()

        then:
        result == [new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")]
    }

    def "test get Restaurant By ID"() {
        given:
        when(restaurantService.findRestaurantByID(anyInt())).thenReturn(new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress"))

        when:
        Restaurant result = restaurantController.getRestaurantByID(0)

        then:
        result == new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme