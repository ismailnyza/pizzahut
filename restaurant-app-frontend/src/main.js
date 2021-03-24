import Vue from "vue";
import Vuex from "vuex";
import "es6-promise/auto";

import App from "./App.vue";
import router from "./router";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import vuetify from "./plugins/vuetify";
import "roboto-fontface/css/roboto/roboto-fontface.css";
import "@mdi/font/css/materialdesignicons.css";
import axios from "axios";
import store from "../src/Store.js";
import Keycloak from "keycloak-js";

// third party addons

Vue.config.productionTip = false;

// state management
Vue.use(Vuex, axios  , router);

fetch("/");

// adding key cloak

let initOptions = {
  url: "http://127.0.0.1:8080/auth",
  realm: "pizzahutapp",
  clientId: "pizzahutkey",
  onLoad: "check-sso",
};

let keycloak = Keycloak(initOptions);

keycloak
  .init({ onLoad: initOptions.onLoad })
  .then((auth) => {
    if (!auth) {
      new Vue({
        el: "#app",
        store,
        router,
        vuetify,
        render: (h) => h(App,
           { props: { keycloak: keycloak } 
        }
          ),
      });
    } else {
      // Vue.$log.info("Authenticated");
      new Vue({
        el: "#app",
        store,
        router,
        vuetify,
        render: (h) => h(App,
           { props: { keycloak: keycloak } 
        }
          ),
      });
    }

    //Token Refresh
  //   setInterval(() => {
  //     keycloak
  //       .updateToken(70)
  //       .then((refreshed) => {
  //         if (refreshed) {
  //           Vue.$log.info("Token refreshed" + refreshed);
  //         } else {
  //           Vue.$log.warn(
  //             "Token not refreshed, valid for " +
  //               Math.round(
  //                 keycloak.tokenParsed.exp +
  //                   keycloak.timeSkew -
  //                   new Date().getTime() / 1000
  //               ) +
  //               " seconds"
  //           );
  //         }
  //       })
  //       .catch(() => {
  //         Vue.$log.error("Failed to refresh token");
  //       });
  //   }, 6000);
  // })
  // .catch(() => {
  //   Vue.$log.error("Authenticated Failed");
  });
