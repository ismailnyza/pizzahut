<template>
  <div class="OrderOnline">
    <h1 class="text-left p-3">Order Online</h1>
    <v-divider></v-divider>
    <div class="row">
      <pizza-card v-for="x in dishes" 
      v-bind:key="x.dishName" 
      :dishName="x.dishname"
      :dishID =String(x.dishid)
      :dishPrice =String(x.dishprice)
      :dishDescription=String(x.dishdesc)
      :imageLink=String(x.dishimg)
      :toppings=toppings
      >
         
      </pizza-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import PizzaCard from "../components/PizzaCard.vue";

export default {
  name: "OrderOnline",
  data() {
    return {
      dishes: [],
      toppings: ["Extra cheese" , "No onions"]
    };
  },
  components: { PizzaCard },
  mounted() {
    axios
      .get("http://localhost:8080/service/Dish/getAllDishes")
      .then((response) => {
        this.dishes = response.data;
      });
  },
};
</script>