package com.example.restaurantappBackend.services

import com.example.restaurantappBackend.Repositories.RestaurantRepository
import com.example.restaurantappBackend.model.Restaurant
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class RestaurantServiceImplTest extends Specification {
    @Mock
    RestaurantRepository restaurantRepository
    @InjectMocks
    RestaurantServiceImpl restaurantServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find Restaurant By ID"() {
        given:
        when(restaurantRepository.findRestaurantsByRestaurantid(anyInt())).thenReturn(new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress"))

        when:
        Restaurant result = restaurantServiceImpl.findRestaurantByID(0)

        then:
        result == new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")
    }

    def "test find All Restaurant"() {
        given:
        when(restaurantRepository.findAll()).thenReturn([new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")])

        when:
        List<Restaurant> result = restaurantServiceImpl.findAllRestaurant()

        then:
        result == [new Restaurant(0, "restaurantname", "restaurantimg", "restaurantaddress")]
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme