<template>
    <div>
      <h3>Our Latest Promotions </h3>
      <hr>
      <!-- needs an idea or -->
      <div class="container">
          <div class="row">
              <div class="col-3">
                  <promotion-card
      imageLink="https://adminsc.pizzahut.lk//images/mainmenu/30bb6ee4-5a96-4ed6-a799-7ad672b57688.jpg"
      promoName="My box"
      PizzaCost="100,00"
      ></promotion-card>
      </div>
       <div class="col-3">
                  <promotion-card
      imageLink="https://adminsc.pizzahut.lk//images/mainmenu/30bb6ee4-5a96-4ed6-a799-7ad672b57688.jpg"
      promoName="My box"
      PizzaCost="100,00"
      ></promotion-card>
      </div>
       <div class="col-3">
                  <promotion-card
      imageLink="https://adminsc.pizzahut.lk//images/mainmenu/30bb6ee4-5a96-4ed6-a799-7ad672b57688.jpg"
      promoName="My box"
      PizzaCost="100,00"
      ></promotion-card>
      </div>
          </div>
          
    </div>
    </div>
</template>

<script>
import PromotionCard from '../components/PromotionCard.vue'
// @ is an alias to /src
// import PizzaCard from '@/components/PizzaCard.vue'

export default {
  name: 'Promotionsview',
  components: {
    PromotionCard
    // PizzaCard
  }
}
</script>
