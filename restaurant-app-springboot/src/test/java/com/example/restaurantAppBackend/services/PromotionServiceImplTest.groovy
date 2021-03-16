package com.example.restaurantappBackend.services

import com.example.restaurantappBackend.Repositories.PromotionRepository
import com.example.restaurantappBackend.model.Promotion
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class PromotionServiceImplTest extends Specification {
    @Mock
    PromotionRepository promotionRepository
    @InjectMocks
    PromotionServiceImpl promotionServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find By Promo ID"() {
        given:
        when(promotionRepository.findPromotionByPromoid(anyInt())).thenReturn(new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice"))

        when:
        Promotion result = promotionServiceImpl.findByPromoID(0)

        then:
        result == new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")
    }

    def "test find Allpromos"() {
        given:
        when(promotionRepository.findAll()).thenReturn([new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")])

        when:
        List<Promotion> result = promotionServiceImpl.findAllpromos()

        then:
        result == [new Promotion(0, "promoname", "promodesc", "promoimg", "promoprice")]
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme