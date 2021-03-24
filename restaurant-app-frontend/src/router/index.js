import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import OrderOnline from "../views/OrderOnline.vue";
import Promotions from "../views/Promotions.vue";
import Restaurants from "../views/Restaurants";
import Cart from "../views/Cart";
import ManageMain from "../views/ManageMain";
import Store from "../Store";

Vue.use(VueRouter);

// ask if this is okay
function loginCheck(to, from , next) {
  if (Store.state.User.isAuthenticated == true) {
    console.log(Store.state.User.isAuthenticated);
    next();
  } else {
    alert("Please login");
    console.log(Store.state.User.isAuthenticated);
    next("/");
  }
}

const routes = [
  {
    path: "",
    name: "Home",
    component: Home,
  },
  {
    path: "/Order",
    name: "Order",
    component: OrderOnline,
  },
  {
    path: "/Promotions",
    name: "Promotions",
    component: Promotions,
  },
  {
    path: "/Restaurants",
    name: "Restaurants",
    component: Restaurants,
  },
  {
    path: "/Cart",
    name: "Cart",
    component: Cart,
  },
  {
    path: "/Manage",
    name: "Manage",
    beforeEnter: loginCheck,
    component: ManageMain,
  },
];

const router = new VueRouter({
  routes,
  // mode: "history",
  linkActiveClass: "active", // active class for non-exact links.
  linkExactActiveClass: "active",
});

export default router;
