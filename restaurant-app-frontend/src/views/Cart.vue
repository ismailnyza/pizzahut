<template>
  <div class="cartBody">
    <div class="container" id="cartcontainer" style="margin-top:5%">
      <h1 style="font-weight: 300" class="white--text">Your Basket</h1>
      <v-simple-table fixed-header height="100%">
        <template v-slot:default>
          <thead>
            <tr class="tableHeading">
              <th class="text-center" style="width: 30%">Item</th>
              <th class="text-center" style="width: 10%">Price</th>
              <th class="text-center" style="width: 40%">Quantity</th>
              <th class="text-center" colspan="1" style="width: 10%">
                Subtotal
              </th>
              <th class="text-center" colspan="2"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="x in cart" :key="x.dishID">
              <td class="text-center">{{ x.dishName }}</td>
              <td class="text-center"> Lkr {{ x.dishPrice }}.00</td>
              <td style="padding-right: 12%; padding-left: 12%">
               <vue-number-input
                  controls
                  rounded
                  small
                  v-model="x.quantity"
                  @click ="changeProductQuantity(x.dishID)"
                ></vue-number-input>
              </td>
              <td class="text-center"> Lkr {{ x.dishPrice * x.quantity }}.00</td>
              <td class="text-center">
                <!-- color="error" -->
                <!-- @click="removeSingleProductInstance()" -->

                <v-btn
                  elevation="2"
                  raised
                  dishID="x.dishID"
                  @click="removeAllInstancesOfSingleProduct(x.dishID)"
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                  >
                    <path
                      d="M9 19c0 .552-.448 1-1 1s-1-.448-1-1v-10c0-.552.448-1 1-1s1 .448 1 1v10zm4 0c0 .552-.448 1-1 1s-1-.448-1-1v-10c0-.552.448-1 1-1s1 .448 1 1v10zm4 0c0 .552-.448 1-1 1s-1-.448-1-1v-10c0-.552.448-1 1-1s1 .448 1 1v10zm5-17v2h-20v-2h5.711c.9 0 1.631-1.099 1.631-2h5.315c0 .901.73 2 1.631 2h5.712zm-3 4v16h-14v-16h-2v18h18v-18h-2z"
                    />
                  </svg>
                </v-btn>
              </td>
              <td></td>
            </tr>
            <tr>
              <td class="text-center">Quantity</td>
              <td></td>
              <td colspan="1" class="text-center">{{ quantity }}</td>

              <td colspan="1" class="text-center"></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="text-center">Total</td>
              <td></td>
              <td></td>
              <td class="text-center">Lkr {{ total }}.00</td>
              <td></td>

              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td>
                <v-btn block elevation="2" @click="clearCart()"
                  color="success" style="white--text">clear Cart</v-btn
                >
              </td>
              <td>
                <v-btn block elevation="2" @click="checkOutCart()"
                  color="success" style="white--text">Check out</v-btn
                >
              </td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
import VueNumberInput from "@chenfengyuan/vue-number-input";

export default {
  components: {
    VueNumberInput,
  },

  computed: { 
    addons(){
      // a getter should be placed here
      return this.$store.state.cart.addons
    },
    cart() {
      return this.$store.getters.getCart;
    },
    total() {
      return this.$store.getters.getTotal;
    },
    quantity() {
      return this.$store.getters.getQuantity;
    },
  },
  methods: {
    // Cart Management
    removeSingleProductInstance() {
      this.$store.dispatch("removeProductInstanceFromCart", {
        imageLink: this.imageLink,
        dishID: this.dishID,
        dishName: this.dishName,
        dishDescription: this.dishDescription,
        dishPrice: parseInt(this.dishPrice),
      });
    },
    clearCart() {
      this.$store.dispatch("removeAllProductsFromCart" , this.$store.state.cart);
    },
    changeProductQuantity(dishID ) {
      this.$store.dispatch("updateProductSingleQunatity" , dishID )
    },
     removeAllInstancesOfSingleProduct(dishID) {
      this.$store.dispatch("removeAllInstancesofSingleProductsFromCart" , dishID )
    },
    checkOutCart(){
      if (this.$store.state.cart.quantity != 0) {
      this.$store.dispatch("checkOutCart")
      this.$store.dispatch("removeAllProductsFromCart")
        alert("your order has been checked out")
      }
      else{
      alert("please add items to your cart")

      }
    }
  
  },
};
</script>

<style>
.cartcontainer {
  height: 100%;
  padding: 5%;
  
}

.cartBody{
  background-color: #1d1c1c;
  height: 100%;
}
</style>

    
