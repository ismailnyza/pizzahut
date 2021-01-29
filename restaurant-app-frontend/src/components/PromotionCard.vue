<template>
  <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
    v-bind:id="promoID"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img height="250" v-bind:src="imageLink" v-bind:alt="promoName">
      <v-row align="end" class="fill-height">
        <v-col align-self="start" class="pa-0" cols="12"> </v-col>
        <v-col class="py-0">
          <v-list-item color="rgba(0, 0, 0, .4)" dark>
            <v-list-item-content>
              <v-list-item-title class="title">
                {{ promoCost }}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-col>
      </v-row>
    </v-img>

    <v-card-title>{{ promoName }}</v-card-title>
    <v-card-subtitle>{{ promoDescription }}</v-card-subtitle>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions>
      <v-btn block color="error" elevation="2" rounded>Add to Cart</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "PromoCard",
  props: {
    imageLink: String,
    promoID: String,
    promoName: String,
    promoCost: Number,
    promoDescription: String,
  },
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
