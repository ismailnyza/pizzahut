<template>
  <v-app>
    <v-app-bar color="primary" dark text app>
      <v-app-bar-title>Pantheons Pizzaria</v-app-bar-title>
      <template v-slot:extension>
        <v-tabs align-with-title>
          <!-- state management to view the selected button is needed -->
          <v-tab href="/">Home</v-tab>
          <v-tab href="/order">Order Online</v-tab>
          <v-tab href="/Promotions">Promotions</v-tab>
          <v-tab href="/Restaurants">Restaurants</v-tab>
        </v-tabs>
      </template>
    </v-app-bar>
    <v-content>
    <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},
};
</script>
