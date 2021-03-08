<template>
  <v-app>
    <v-app-bar color="primary" dark text app>
      <v-app-bar-title>Pantheons Pizzaria</v-app-bar-title>
      <template v-slot:extension>
          <v-tabs  v-model="active_tab" align-with-title>
     <v-tab
      v-for="tab of tabs"
      :key="tab.index"
      v-bind:to = "tab.to"
     >
     {{tab.name}}
     </v-tab>
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
  data(){
    return{
      active_tab : this.$store.currentPageIndex, 

      tabs : [
        { index : 0 , to :"/",  name: 'Home'},
        { index : 1 , to :"/order",  name: 'Order Online'},
        { index : 2 , to :"/Promotions",  name: 'Promotions'},
        { index : 3 , to : "/Restaurants",  name: "Restaurants"} , 
        { index : 4 , to : "/Cart",  name: "Cart"},
        { index : 5 , to : "/Manage",  name: "Manage"}
      ]
    }
  } , 
  

};
</script>
<style scoped>

 v-tab:hover,
  v-tab.router-link-active,
  v-tab.router-link-exact-active {
   color: indianred;
   cursor: pointer;
 }

 body{
  padding: 2.3%;
}
</style>
