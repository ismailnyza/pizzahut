<template>
  <v-card style="margin-top: 5%">
    <div class="itemInCartCard">
      <div class="row">
        <div class="col-1" style="padding-top: 5%">
          <v-btn
            color="accent"
            elevation="2"
            icon
            @click="removeAllInstancesOfSingleProduct(dishID)"
            ><svg style="width: 24px; height: 24px" viewBox="0 0 24 24">
              <path
                fill="red"
                d="M19,4H15.5L14.5,3H9.5L8.5,4H5V6H19M6,19A2,2 0 0,0 8,21H16A2,2 0 0,0 18,19V7H6V19Z"
              /></svg
          ></v-btn>
        </div>
        <div class="col-2">
          <v-avatar size="75" style="float: left"
            ><img v-bind:src="imageLink"
          /></v-avatar>
        </div>
        <div class="col-3 text-center">
          <div class="font-weight-light" style="padding-top: 15%">
            {{ dishName }}
          </div>
          <div class="font-weight-light" style="font-size: 80%">
            Lkr {{ dishPrice }}.00
          </div>
        </div>
        <v-divider vertical></v-divider>
        <div class="col-2 text-center" style="padding-top: 8%; font-size:90%;">
          <!-- method that updates total on change -->
          {{ quantity }}
        </div>
        <v-divider vertical></v-divider>
        <div
          class="col-3 text-center"
          style="padding-top: 8%; padding-left: 5%"
        >
          LKR {{ dishPrice * quantity }}.00
        </div>
      </div>
      {{ total }}
    </div>
  </v-card>
</template>

<script>
export default {
  name: "itemInCart",
  components: {},

  props: {
    imageLink: String,
    dishID: String,
    dishName: String,
    dishDescription: String,
    dishPrice: String,
    quantity: Number,
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
      this.$store.dispatch("removeAllProductsFromCart", this.$store.state.cart);
    },
    changeProductQuantity(dishID) {
      this.$store.dispatch("updateProductSingleQunatity", dishID);
    },
    removeAllInstancesOfSingleProduct(dishID) {
      this.$store.dispatch(
        "removeAllInstancesofSingleProductsFromCart",
        dishID
      );
    },
    checkOutCart() {
      this.$store.dispatch("checkOutCart");
    },
  },
};
</script>

<style scoped>
#B00 {
  padding: 45% 5% 25% 5%;
  font-weight: 300;
  line-height: 160%;
  /* if needed */
  border-radius: 1.33%;
  color: #41c485;
}

#imgB01 {
  height: 70%;
  padding: 0% 0% 0% 0%;
  margin: 5%;
}

.B03 {
  font-size: 150%;
  font-weight: 300;
}

.B03Card {
  background-color: transparent;
  font-weight: 300;
}

.B04CardStack {
  padding-top: 28%;
}

.hello {
  padding: 1%;
  background-color: #1d1c1c;
}

/* ----------------- */
.itemInCartCard {
  padding: 1.5%;
}

.numberInput {
  font-size: 40%;
}
</style>
