<template>
  <v-app>
    <v-app-bar color="primary" dark text app>
      <v-app-bar-title>Pantheons Pizzaria</v-app-bar-title>
      <template v-slot:extension>
        <v-tabs v-model="active_tab" align-with-title>
          <v-tab v-for="tab of tabs" :key="tab.index" v-bind:to="tab.to">
            {{ tab.name }}
          </v-tab>
        </v-tabs>
        <v-btn id="btnLogin" elevation="2" @click="login()">Login</v-btn>
        <v-btn id="btnLogout" elevation="2" @click="logout()">Log Out</v-btn>
      </template>
    </v-app-bar>

    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Keycloak from "keycloak-js";
export default {
  name: "App",
  props: {
    Keycloak: Keycloak,
  },
  components: {},
  data() {
    return {
      active_tab: this.$store.currentPageIndex,

      tabs: [
        { index: 0, to: "/", name: "Home" },
        { index: 1, to: "/order", name: "Order Online" },
        { index: 2, to: "/Promotions", name: "Promotions" },
        { index: 3, to: "/Restaurants", name: "Restaurants" },
        { index: 4, to: "/Cart", name: "Cart" },
        { index: 5, to: "/Manage", name: "Manage" },
      ],
    };
  },

  methods: {
    logout() {
      this.$store.state.User.userType = "";
      this.$store.state.User.isAuthenticated = false;
      this.$store.state.User.userID = "";
      this.Keycloak.logout();
     
    },
    login() {
      this.Keycloak.login();
    },
  },

  mounted() {
    if (this.Keycloak.authenticated == true) {
      this.$store.state.User.userID = this.Keycloak.idTokenParsed.given_name;
      this.$store.state.User.isAuthenticated = true;
      this.$store.state.User.userType = this.Keycloak.realmAccess.roles[0];
// changing the button
      document.getElementById("btnLogin").innerText =
        "Welcome Back " + this.$store.state.User.userID;

        // user roles check
      if (this.$store.state.User.userType == "admin") {
        document.getElementById("btnLogin").style.backgroundColor = "Red";
        console.log(this.$store.state.userType);
      } else if (this.$store.state.User.userType == "customer") {
        document.getElementById("btnLogin").style.backgroundColor = "Blue";
        console.log(this.$store.state.userType);
      }
    } else if (this.Keycloak.authenticated == false) {
      console.log("not logged in");
      document.getElementById("btnLogin").innerText = "Log In";
      document.getElementById("btnLogout").style.display = "none";
    }
  },
};
</script>
<style scoped>
v-tab:hover,
v-tab.router-link-active,
v-tab.router-link-exact-active {
  color: indianred;
  cursor: pointer;
}

body {
  padding: 2.3%;
}
</style>
