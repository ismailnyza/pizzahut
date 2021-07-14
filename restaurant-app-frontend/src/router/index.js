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

function loginCheck(to, from , next) {
  if (Store.state.User.isAuthenticated == true) {
    console.log(Store.state.User.isAuthenticated);
    next();
  } else {
    alert("Please Login to Use this service");
    console.log(Store.state.User.isAuthenticated);
    next("/");
  }
}


function adminCheck(to, from , next) {
  if (Store.state.User.isAuthenticated == true && Store.state.User.userType === "admin") {
    console.log(Store.state.User.isAuthenticated);
    console.log(Store.state.User.userType);
    next();
  } else {
    alert("You Do Not Have Permission to access this page");
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
    beforeEnter: loginCheck,
    component: OrderOnline,
  },
  {
    path: "/Promotions",
    name: "Promotions",
    beforeEnter: loginCheck,
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
    beforeEnter: loginCheck,
    component: Cart,
  },
  {
    path: "/Manage",
    name: "Manage",
    beforeEnter: adminCheck,
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
