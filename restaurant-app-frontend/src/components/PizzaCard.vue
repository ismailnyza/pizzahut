<template>
  <v-card class="mx-10 my-15" max-width="260" v-bind:id="dishID">
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img height="175" v-bind:src="imageLink" v-bind:alt="dishName">
      <v-row align="end" class="fill-height">
        <v-col align-self="start" class="pa-0" cols="12"> </v-col>
        <v-col class="py-0">
          <v-list-item color="rgba(0, 0, 0, .4)" dark>
            <v-list-item-content>
              <v-list-item-title class="title" id="overlayText">
                LKR {{ dishPrice }}.00
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-col>
      </v-row>
    </v-img>

    <v-card-title>{{ dishName }}</v-card-title>
    <v-card-subtitle>{{ dishDescription }}</v-card-subtitle>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions>
      <v-btn
        block
        color="error"
        elevation="2"
        @click="reveal = true"
        class="btnAddtoCart"
        >Add to Cart</v-btn
      >
    </v-card-actions>

    <v-expand-transition>
      <v-card
        v-if="reveal"
        class="transition-fast-in-fast-out v-card--reveal"
        style="height: 100%"
      >
        <v-btn color="error" block @click="reveal = false"> X </v-btn>
        <v-card-text class="pb-0">
          <v-select
            v-model="selectedTopping"
            label="Pick your favorite Toppings"
            :items="toppings"
            item-text="toppingname"
            item-value="toppingprice"
            return-object
          ></v-select>
        </v-card-text>
        <!-- fix the buttons and the choices -->
        <div class="container" style="clear: both">
          Pizza Price :
          <span class="alignright">LKR {{ dishPrice }}.00</span><br />
          Toppings Price :
          <span class="alignright"
            >LKR {{ this.selectedTopping.toppingprice }}.00</span
          ><br /><br />
          <hr />
          Total
          <span class="alignright"
            >LKR
            {{
              parseInt(this.dishPrice) +
              parseInt(this.selectedTopping.toppingprice)
            }}.00</span
          >
          <hr />
        </div>
        <v-card-actions>
          <v-btn
            id="btnAddtoCart"
            block
            color="primary"
            class="btnAddtoCart"
            @click="addToCart(dishID, selectedTopping.toppingprice)"
          >
            Add To Cart
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-expand-transition>
  </v-card>
</template>


<script>
export default {
  name: "PizzaCard",
  props: {
    imageLink: String,
    dishID: String,
    dishName: String,
    dishDescription: String,
    dishPrice: String,
    toppings: String,
  },
  data: () => ({
    reveal: false,
    selectedTopping: {
      toppingprice: 0,
      toppingname: "",
    },
    tempTotal: 0,
    instructions: "",
    addons: 0,
  }),
  methods: {
    addToCart() {
      if (this.selectedTopping.toppingname != "") {
        this.instructions +=
          this.dishName + " with " + this.selectedTopping.toppingname + ",  ";
      } else {
        this.instructions += this.dishName + " , ";
      }

      this.tempTotal =
        parseInt(this.dishPrice) + parseInt(this.selectedTopping.toppingprice);
      this.addons += parseInt(this.selectedTopping.toppingprice);

      this.$store.dispatch("addToCart", {
        imageLink: this.imageLink,
        dishID: this.dishID,
        dishName: this.dishName,
        dishDescription: this.dishDescription,
        // the price of the selecected topping will be added to the cart as the price of the pizza itself for easy calculations
        dishPrice: parseInt(this.dishPrice),
        instructions: this.instructions,
        addons: this.addons,
      });

      // closing the button and returning to the null state
      this.reveal = false
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* h3 {
  margin: 40px 0 0;
} */
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  margin: 2.5%;
}

.v-card--reveal {
  bottom: 0;
  opacity: 0.95 !important;
  position: absolute;
  width: 100%;
}

.btnAddtoCart {
  position: absolute;
  right: 0;
  bottom: 0;
}

#overlayText {
  color: whitesmoke;
}
.alignleft {
  float: left;
}
.alignright {
  float: right;
}
</style>
