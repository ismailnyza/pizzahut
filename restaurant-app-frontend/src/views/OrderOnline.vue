<template>
  <div class="OrderOnline">
    <h1 class="text-left p-3">Order Online</h1>
    <v-divider></v-divider>
    <div class="row">
      <pizza-card
        v-for="x in dishes"
        v-bind:key="x.dishname"
        :dishName="x.dishname"
        :dishID="String(x.dishid)"
        :dishPrice="x.dishprice"
        :dishDescription="String(x.dishdesc)"
        :imageLink="String(x.dishimg)"
        :toppings="toppings"
      >
      </pizza-card>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
import PizzaCard from "../components/PizzaCard.vue";

export default {
  components: {
    PizzaCard,
  },
  computed: {
    dishes() {
      return this.$store.state.dishes;
    },
    toppings(){
      return this.$store.state.toppings;
    }
  },
  mounted() {
    this.$store.dispatch("loadProducts");
    this.$store.dispatch("loadToppings");
  }
  
};
</script>

