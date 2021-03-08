<template>
  <div>
    <h3>We have multiple Restaurants to Serve you better</h3>
    <v-divider> </v-divider>
    <div class="row">
      <restaurant-card
        v-for="x in restaurants"
        v-bind:key="x.restaurantid"
        :RestaurantName="x.restaurantname"
        :RestaurantID="String(x.restaurantid)"
        :RestaurantAddress="String(x.restaurantaddress)"
        :imageLink="String(x.restaurantimg)"
      >
      </restaurant-card>
    </div>
  </div>
</template>

<script>
import RestaurantCard from "../components/RestaurantCard.vue";
// @ is an alias to /src
// import RestaurantCard from '../components/RestaurantCard.vue'

export default {
  name: "Restaurants",
  components: {
    RestaurantCard,
  },
  computed: {
    restaurants() {
      return this.$store.state.branches;
    },
  },
  mounted() {
    this.$store.dispatch("loadBranches");
  },
};
</script>
<style>
body {
  padding: 2.3%;
}
</style>
