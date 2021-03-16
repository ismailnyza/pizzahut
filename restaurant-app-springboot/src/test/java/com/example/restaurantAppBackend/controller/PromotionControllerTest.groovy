package com.example.restaurantappBackend.controller

import com.example.restaurantappBackend.Repositories.PromotionRepository
import com.example.restaurantappBackend.model.Promotion
import com.example.restaurantappBackend.services.PromotionServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class PromotionControllerTest extends Specification {
    @Mock
    PromotionRepository PromotionRepository
    @Mock
    PromotionServiceImpl promotionService
    @InjectMocks
    PromotionController promotionController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test get All Dishes"() {
        given:
        when(promotionService.findAllpromos()).thenReturn([new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")])

        when:
        List<Promotion> result = promotionController.getAllDishes()

        then:
        result == [new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")]
    }

    def "test get Promotion By ID"() {
        given:
        when(promotionService.findByPromoID(anyInt())).thenReturn(new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice"))

        when:
        Promotion result = promotionController.getPromotionByID(0)

        then:
        result == new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme