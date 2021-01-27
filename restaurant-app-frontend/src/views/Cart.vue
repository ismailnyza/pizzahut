<template>
    <div>
      <h3>You Currently have {{numberOfItemsInCard}} in your cart</h3>      
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
      <th scope="col">{{totalBill}}</th>
      <th scope="col"><button class="btn btn-primary" type="submit">Checkout</button></th>
      <th scope="col"><button class="btn btn-primary" type="submit">Clear Cart</button></th>
    </tr>
  </thead>
</table>
      </div>

    </div>
</template>

<script>
// @ is an alias to /src
// import PizzaCard from '@/components/PizzaCard.vue'

export default {
  name: 'Cart',
  components: {
    // PizzaCard
  }
}
</script>
