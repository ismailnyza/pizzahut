<template>
 <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
    v-bind:id="RestaurantID" 
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img height="250" v-bind:src="imageLink" v-bind:alt="RestaurantName">
      <v-row align="end" class="fill-height">
        <v-col align-self="start" class="pa-0" cols="12"> </v-col>
        <v-col class="py-0">
          <v-list-item color="rgba(0, 0, 0, .4)" dark>
            <v-list-item-content>
              <v-list-item-title class="title" >
                <!-- fix here -->
                <v-text>{{ RestaurantName }}</v-text>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-col>
      </v-row>
    </v-img>

    <v-card-title><v-btn color="primary" v-bind:href="RestaurantAddress">view on google maps</v-btn></v-card-title>
    <v-card-subtitle>{{ dishDescription }}</v-card-subtitle>

  </v-card>
  </template>

<script>
export default {
  name: "RestaurantCard",
    props: {
      imageLink: String ,
      RestaurantID: String ,
      RestaurantName : String,
      RestaurantAddress : String,
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
    margin: 2.5%;

}
</style>
