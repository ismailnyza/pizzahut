<template>
  <div>
    <h3>Our Latest Promotions</h3>
    <v-divider></v-divider>
        <div class="row">
         <pizza-card
        v-for="x in promotions"
        v-bind:key="x.promoname"
        :dishName="x.promoname"
        :dishID="String(x.promoid)"
        :dishPrice="x.promoprice"
        :dishDescription="String(x.promodesc)"
        :imageLink="String(x.promoimg)"
        :toppings="toppings"

      >
      </pizza-card>
        </div>
  </div>
</template>

<script>
import PizzaCard from '@/components/PizzaCard.vue'

export default {
  name: "Promotionsview",
  components: {
    PizzaCard
  }, computed: {
    promotions() {
      return this.$store.state.promotions;
    },toppings(){
      return this.$store.state.toppings;
    }
  },
  mounted() {
    this.$store.dispatch("loadPromos");
    this.$store.dispatch("loadToppings");
  }
};
</script>
<style>
body{
  padding: 2.3%;
}
</style>
