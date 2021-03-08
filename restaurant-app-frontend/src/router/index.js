import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import OrderOnline from "../views/OrderOnline.vue";
import Promotions from "../views/Promotions.vue";
import Restaurants from "../views/Restaurants";
import Cart from "../views/Cart";
import ManageMain from "../views/ManageMain";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
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
