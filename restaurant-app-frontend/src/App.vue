<template>
  <v-app>
    <v-app-bar color="black" dark centered text app>
      <v-tab class="navbarBrand" disabled>Hands Are Toasters</v-tab>
      <v-tabs centered>
        <v-tab v-for="tab of tabs" :key="tab.index" v-bind:to="tab.to">
          {{ tab.name }}
        </v-tab>
      </v-tabs>
      <v-btn
        id="btnLogin"
        elevation="2"
        @click="login()"
        style="margin-right: 1%"
        >Login</v-btn
      >
      <v-btn
        id="btnLogout"
        elevation="2"
        style="margin-right: 1%; background-color: #aaaaaa"
        @click="logout()"
        >Log Out</v-btn
      >
      <v-avatar
        id="profilePicture"
        style="display: none"
        rounded
        size="38"
      ></v-avatar>
    </v-app-bar>
    <router-view></router-view>
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

      tabs: [],
    };
  },

  methods: {
    details() {
      console.log(this.Keycloak.realmAccess.roles[0]);
    },

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
      this.$store.state.User.profilePicture =
        this.Keycloak.idTokenParsed.profilePicture;
      document.getElementById("btnLogin").innerText =
        this.$store.state.User.userID;

      document.getElementById("profilePicture").innerHTML =
        "<img src =" + this.$store.state.User.profilePicture + " >";
      document.getElementById("profilePicture").style = "display:show";
      // user roles check
      if (this.$store.state.User.userType == "admin") {
        console.log(this.$store.state.userType);
        this.tabs = [
          { index: 0, to: "/", name: "Home" },
          { index: 1, to: "/order", name: "Order Online" },
          { index: 5, to: "/Manage", name: "Manage" },
        ];
      } else if (this.$store.state.User.userType == "customer") {
        document.getElementById("btnLogin").style.backgroundColor = "Blue";
        console.log(this.$store.state.userType);
        this.tabs = [
          { index: 0, to: "/", name: "Home" },
          { index: 1, to: "/order", name: "Order Online" },
          { index: 2, to: "/Promotions", name: "Promotions" },
          { index: 3, to: "/Restaurants", name: "Restaurants" },
          { index: 4, to: "/Cart", name: "Cart" },
        ];
      }
    } else if (this.Keycloak.authenticated == false) {
      console.log("not logged in");
      document.getElementById("btnLogin").innerText = "Log In";
      document.getElementById("btnLogout").style.display = "none";
      this.tabs = [
        { index: 0, to: "/", name: "Home" },
        { index: 1, to: "/order", name: "Order Online" },
        { index: 3, to: "/Restaurants", name: "Restaurants" },
      ];
    }
  },
};
</script>

<style>
v-tab:hover,
v-tab.router-link-exact-active {
  color: indianred;
  cursor: pointer;
}

v-tab {
  font-size: 150%;
}

v-app {
  background-color: "#1d1c1c";
}

#btnLogin {
  background-color: #41c485;
}

v-main {
  padding: 0;
  margin: 0;
  height: 100%;
}

/* background needs to be edited in 2 places */
</style>
