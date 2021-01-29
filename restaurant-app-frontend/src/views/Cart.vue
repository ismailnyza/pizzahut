<template>
    <div class="container" >
      <h1>You Currently have in your cart</h1>      
      <hr>
      <div class="container">
      <table class="table">
  <thead>
    <tr>
      <th scope="col">Dish Name</th>
      <th scope="col">dishDescription</th>
      <th scope="col">Additional Requests</th>
      <th scope="col">dishPrice</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
  </tbody>
  <thead>
      <tr>
      <th scope="col">Total</th>
      <th scope="col">{{  this.$store.state.count }}</th>
      <th scope="col"><button class="btn btn-primary" type="submit">Checkout</button></th>
      <th scope="col"><button class="btn btn-primary" type="submit" @click="increment()">Clear Cart</button></th>
    </tr>
  </thead>
</table>
      </div>

    </div>
</template>

<script>
// import PizzaCard from '@/components/PizzaCard.vue'

export default {
  data() {
   
  },
  methods: {
  increment() {
    this.$store.commit('increment')
    console.log(this.$store.state.count)
  }
}, 
  components: {
    // PizzaCard
  }
}
</script>
<style>
</style>