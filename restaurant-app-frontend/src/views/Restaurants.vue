<template>
  <div class="restaurantPage">
    <h3 class="pageHeader display-3">We have multiple Restaurants to Serve you better</h3>
    <v-divider> </v-divider>
    <div class="row " style="padding-left:13%; padding-right:10%;">
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
.pageHeader{
  padding-left: 2.5%;
  padding-top : 3%;
  padding-bottom : 1%;
  font-weight: 300;
  color: white;
}

.restaurantPage{
  background-color: #1d1c1c;
}

hr{
   background-color: white;
  width: 95%;
  float: center;
  margin-left: 1%;
  border-top: 3px double;}
</style>
