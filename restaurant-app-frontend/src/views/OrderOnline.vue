<template>
  <div class="OrderOnline">
    <div class="row">
      <div class="col-8">
        <v-card color="black" dark flat>
          <v-card-title class="text-center justify-center py-6">
            <h1 class="display-3 basil--text">Our Hottest New Dishes</h1>
          </v-card-title>

          <v-tabs v-model="tab" background-color="#1d1c1c" color="basil">
            <v-tab
              v-for="item in items"
              :key="item"
              @click="changeDishType(item)"
            >
              {{ item }}
            </v-tab>
          </v-tabs>

          <v-tabs-items v-model="tab">
            <v-tab-item v-for="item in items" :key="item">
              <v-card color="#1d1c1c">
                <br />
                <h2>{{ dishType }}</h2>
                <div class="row">
                  <pizza-card
                    v-for="x in dishes"
                    v-bind:key="x.dishname"
                    :dishName="x.dishname"
                    :dishID="String(x.dishid)"
                    :dishPrice="x.dishprice"
                    :dishDescription="String(x.dishdesc)"
                    :imageLink="String(x.dishimg)"
                  >
                  </pizza-card>
                </div>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </v-card>
        <!-- pagination -->
        <v-pagination
          v-model="page"
          :length="dishcount"
          @input="handlePageChange"
          style="padding-left: 5%; padding-bottom: 3%; margin: 0%; float: left"

        ></v-pagination>


        <!--  -->
      </div>
      <div class="col-4" id="cartMain">
        <v-card-title class="text-left justify-center py-6">
          <h1 class="display-3 basil--text">Cart</h1>
          <hr />
        </v-card-title>
        <div class="row">
          <div class="col-5 text-right white--text">Dish</div>
          <div class="col-4 text-center white--text">Quantity</div>
          <div class="col-3 text-left white--text">Unit Total</div>
        </div>
        <!-- items in the cart should be shown  -->
        <v-card>
          <item-in-cart
            v-for="x in cart"
            v-bind:key="x.dishname"
            :dishName="String(x.dishName)"
            :dishID="String(x.dishID)"
            :dishPrice="String(x.dishPrice)"
            :dishDescription="String(x.dishDescription)"
            :imageLink="String(x.imageLink)"
            :quantity="x.quantity"
          >
          </item-in-cart>
        </v-card>
        <br />
        <br />
        <hr />
        <div class="row white--text" style="padding-left: 70%; padding-top: 2%">
          Total : LKR {{ total }}.00
        </div>
        <div class="row" style="padding-left: 0%; padding-top: 2%">
          <div class="col-5">
            <v-btn block elevation="2" @click="clearCart()">clear Cart</v-btn>
          </div>
          <div class="col-5">
            <v-btn block elevation="2" @click="checkOutCart()">Check out</v-btn>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ItemInCart from "../components/itemInCart.vue";
// import axios from "axios";
import PizzaCard from "../components/PizzaCard.vue";

import pizzaService from "../services/pizzaService";

export default {
  components: {
    PizzaCard,
    ItemInCart,
  },
  computed: {
    cart() {
      return this.$store.state.cart.items;
    },
  },

  data: () => ({
    dishes: [],
    total: 0,
    tab: null,
    items: ["Pizza", "Entree", "Desert", "Meal"],

    page: 1,
    count: 1,

    pageSize: 10,
    dishType: "Pizza",
    dishTypes: ["Pizza", "Entree", "Desert", "Meal"],
    sortType: "dishid",
    dishcount : null
  }),
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
      console.log(this.cart);
      console.log(this.$store.state.cart.items);
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
      if (this.$store.state.cart.quantity != 0) {
        this.$store.dispatch("checkOutCart");
        this.$store.dispatch("removeAllProductsFromCart");
        alert("your order has been checked out");
      } else {
        alert("please add items to your cart");
      }
    },

    getRequestParams(page, pageSize, sortType, dishType) {
      let params = {};

      // if the field is not null
      if (page) {
        params["page"] = page;
      }

      if (pageSize) {
        params["pageSize"] = pageSize;
      }
      if (sortType) {
        params["sortType"] = sortType;
      }
      if (dishType) {
        params["dishType"] = dishType;
      }
      return params;
    },

    retrieveDishes() {
      const params = this.getRequestParams(
        this.page,
        this.pageSize,
        this.sortType,
        this.dishType
      );

      pizzaService
        .getAllPaginated(params)
        .then((response) => {
          const a = response.data;
          this.dishes = a.content;
          this.count = a.totalElements;
          this.dishcount = Math.ceil(this.count / this.pageSize);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    changeDishType(item) {
      this.dishType = item;
      this.retrieveDishes();
    },
    handlePageChange(value) {
      this.pageno = value;
      this.currentDish = null;
      this.currentIndex = null;
      this.retrieveDishes();
    },
  },
  mounted() {
    this.retrieveDishes();
    this.cart = this.$store.state.cart.items;
  },
};
</script>

<style scoped>
h1 {
  color: white;
  font-weight: 250;
}

hr {
  background-color: white;
  width: 95%;
  float: center;
  margin-left: 1%;
  border-top: 3px double;
}
.OrderOnline {
  background-color: #1d1c1c;
  padding: 2%;
  height: 100%;
}

.basil {
  background-color: #fffbe6 !important;
}
.basil--text {
  color: #ffffff !important;
  font-weight: 250;
}

#cartMain {
  background-color: #2e2a2a;
}

</style>
