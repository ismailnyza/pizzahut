<template>
  <v-card width="45%" height="100%" class="mx-7 my-6">
    <div class="d-flex flex-no-wrap justify-space-between pizzaCard">
      <div>
        <v-card-title class="vCardTitle">{{ dishName }}</v-card-title>
        <hr>
        <v-card-text> {{ dishDescription }} </v-card-text>
        <v-card-text class="cardTxtMoney"> LKR {{ dishPrice }}.00 </v-card-text>
        <v-card-actions>
        <v-btn  @click="addToCart(dishID, selectedTopping.toppingprice) " color="success" style="white--text">Add To Cart </v-btn>
        </v-card-actions>
        <br>

      </div>

      <v-avatar class="ma-3" size="175" tile>
        <v-img :src="imageLink"></v-img>
      </v-avatar>
    </div>
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
      this.reveal = false;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.vCardTitle{
  font-size: 100%;
  font-weight: 400;
  padding: 5%  0  0 5% ;
  margin: 0;
  line-height: 1;
}

.pizzaCard{
  background-color: whitesmoke;
  
}

.cardTxtMoney{
  font-weight: 400;
  font-style: italic;
  padding-bottom: 0;
}



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
