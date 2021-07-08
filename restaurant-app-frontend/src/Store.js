import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import { Date } from "core-js";
import Keycloak from "keycloak-js";


Vue.use(Vuex , Keycloak);

export default new Vuex.Store({
  // state is the same as what would typically go inside of the data object when using Vue without Vuex.

  // reason for using state management 
  state: {
    cart: {
      items: [],
      promotions: [],
      total: 0,
      quantity: 0,
      instructions : "",
      addons: 0
    },
    User: {
      userID : "",
      userToken : "",
      isAuthenticated : false,
      userType : "",
      userImage : "" , 
    },
    currentPageIndex: 0,
    dishes: [],
    branches : [],
    promotions : [],
    // giving toppings a seperate api would be idea since then it cant be edited from the front end :) there you explained it to your self done
    toppings : [],
    tempTotal: 0,
    cartAsArray : " ",
  },

  // mutations are essentially functions that update state in some way.
  // You can think of these as kind of being Vuex's equivalent to Vue's methods.
  mutations: {
    addProducttoCart(state, payload) {
      const dishData = payload;
      const dishInCartIndex = state.cart.items.findIndex(
        (cartItem) => cartItem.dishID === dishData.dishID
      );
      if (dishInCartIndex >= 0) {
        state.cart.items[dishInCartIndex].quantity++;
        state.cart.quantity++;
        state.cart.total += parseInt(dishData.dishPrice);
        state.cart.instructions +=  dishData.instructions ;
        state.cart.addons += parseInt(dishData.addons);
      } else {
        const newItem = {
          imageLink: dishData.imageLink,
          dishID: dishData.dishID,
          dishName: dishData.dishName,
          dishDescription: dishData.dishDescription,
          dishPrice: dishData.dishPrice,
          quantity: 1,
        };
        state.cart.items.push(newItem);
        console.log(newItem);
        state.cart.quantity++;
        state.cart.total += parseInt(dishData.dishPrice);
        state.cart.instructions +=  dishData.instructions ;
        state.cart.addons += parseInt(dishData.addons);
        console.log(state.cart.instructions)
      }
      if (parseInt(dishData.addons) != 0) {
        state.cart.total += parseInt(dishData.addons)
      }
    },

    removeProductFromCart(state, payload) {
      const dishID = payload.dishid;
      const dishInCartIndex = state.cart.items.findIndex(
        (cartItem) => cartItem.dishid === dishID
      );
      const dishData = state.cart.items[dishID];
      state.cart.items.splice(dishInCartIndex, 1);
      state.cart.items.quantity -= dishData.quantity;
      state.cart.total -= dishData.dishPrice;
    },

    // important function needs to be fixed -- fixed
    // ------------------------------------
    updateProductSingleQunatity(state, payload) {
      const dishID = payload;
      const dishInCartIndex = state.cart.items.findIndex(
        (cartItem) => cartItem.dishID === dishID
      );
      state.cart.tempQuantity = state.cart.items[dishInCartIndex].quantity;
      state.cart.total = 0;
      state.cart.quantity = 0;

      for (let index = 0; index < state.cart.items.length; index++) {
        const tempTotal =
          state.cart.items[index].dishPrice * state.cart.items[index].quantity;
        state.cart.total += tempTotal;
        state.cart.quantity += state.cart.items[index].quantity
        console.log(tempTotal, index);
      }
    },
    // ------------------------------------
    removeAllProductsFromCart(state) {
      state.cart.items = [];
      state.cart.quantity = 0;
      state.cart.total = 0;
      state.cart.addons = 0;
    },

    removeAllInstancesofSingleProductsFromCart(state, payload) {
      const dishID = payload;
      const dishInCartIndex = state.cart.items.findIndex(
        (cartItem) => cartItem.dishID === dishID
      );
      const quantity = parseInt(state.cart.items[dishInCartIndex].quantity);
      const total = parseInt(
        state.cart.items[dishInCartIndex].dishPrice * quantity
      );
      state.cart.items.splice(dishInCartIndex, 1);
      state.cart.total -= total;
      state.cart.quantity -= quantity;
    },

    changeActivePage(state, payload) {
      this.currentPage = payload;
    },
    loadProductsFromAPI(state, payload) {
      state.dishes = payload;
    },
    loadBranchesFromAPI(state, payload) {
      state.branches = payload;
    },
    loadPromosFromAPI(state, payload) {
      state.promotions = payload;
    },
    loadToppingsFromAPI(state, payload) {
      state.toppings = payload;
    },

    // post requests 
    // does a post request need a mutation
    // postDishes()


    // fixed
    checkOutCart(state){
      for (let index = 0; index < state.cart.items.length; index++) {
       state.cartAsArray = state.cartAsArray+" "+state.cart.items[index].dishName+"*"+state.cart.items[index].quantity+", "; 
      }
      state.cartAsArray = state.cartAsArray.replace(/(\r\n|\n|\r)/gm," ");
      axios.post('http://localhost:8082/service/sale',{
        "purchasedtotal":String(state.cart.total),
        "purchasedcart": String(state.cartAsArray),
        "purchasedtime" : String(Date().slice(0,15).replace(/-/g,'/'))
      })
      state.cartAsArray = "";
      console.log(String(Date().slice(0,15).replace(/-/g,'/')))
    }
  },
  // actions are effectively the functions that get called by your components in order to trigger a mutation.
  actions: {
    // api calls for products , locations and branches 
    // --------------------------------------------------------
    loadProducts({ commit }) {
      axios
        .get("http://localhost:8082/service/Dish/getAllDishes")
        .then((response) => {
          commit("loadProductsFromAPI", response.data);
        });
    },
    loadBranches({ commit }) {
      axios
        .get("http://localhost:8082/service/Restaurant/getAllRestaurants")
        .then((response) => {
          commit("loadBranchesFromAPI", response.data);
          console.log(response.data)
        });
    },
    loadPromos({ commit }) {
      axios
        .get("http://localhost:8082/service/Promo/getAllPromos")
        .then((response) => {
          commit("loadPromosFromAPI", response.data);
        });
    },

    loadToppings({ commit }) {
      axios
        .get("http://localhost:8082/service/Topping/getAllToppings")
        .then((response) => {
          commit("loadToppingsFromAPI", response.data);
        });
    },

    // response => this.dishid = response.data.dishid ,  this might be needed but lets see
    postDishes() {
      axios
      .post("http://localhost:8082/service/Dish/UpdateAll" , this.state.dishes)
      .then(console.log(this.state.dishes))
    },
    // --------------------------------------------------------

    addToCart(context, payload) {
      context.commit("addProducttoCart", payload);
    },
    removeFromCart(context, payload) {
      context.commit("removeProductFromCart", payload);
    },
    updateProductSingleQunatity(context, payload) {
      context.commit("updateProductSingleQunatity", payload);
    },
    removeAllProductsFromCart(context) {
      context.commit("removeAllProductsFromCart");
    },

    removeAllInstancesofSingleProductsFromCart(context, payload) {
      context.commit("removeAllInstancesofSingleProductsFromCart", payload);
    },
    checkOutCart(context){
      context.commit("checkOutCart");
    }
    // add(context) {
    //     context.commit('add')
    // }
  },
  // getters are Vuex's equivalent to computed properties in Vue.
  // functions here will always contain state as a parameter

  getters: {
    getItems: (state) => {
      return state.cart.items;
    },
    getTotal: (state) => {
      return state.cart.total;
    },
    getQuantity: (state) => {
      return state.cart.quantity;
    },
    getCart: (state) => {
      return state.cart.items;
    },
  },
});
