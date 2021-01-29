<template>
  <div class="container">
    <div class="row">
      <div class="col-4">
        <pizza-card-customize
          imageLink="data:image/jpeg;base64,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"
          dishID="dish id"
          dishName="pantheonisawsdome"
          dishDescription="he coocked this himself"
          dishPrice="1 nexus tower"
        />
      </div>
      <div class="col-8">
        <form>
          <div class="form-group">
            <template>
              <v-card flat>
                <v-card-text>
                  <v-container fluid>
                    <h4>Customize Pizza</h4>
                    <v-row>
                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="Extra Cheese"
                          color="red"
                          value="extraCheese"
                          hide-details
                        ></v-checkbox>
                      </v-col>

                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="Crusts Cut Off"
                          color="indigo"
                          value="crustCutOff"
                          hide-details
                        ></v-checkbox>
                      </v-col>
                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="No Onions"
                          color="red darken-3"
                          value="noOnions"
                          hide-details
                        ></v-checkbox>
                      </v-col>
                    </v-row>

                    <v-row class="mt-12">
                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="Extra Cheese"
                          color="primary"
                          value="extraCheese"
                          hide-details
                        ></v-checkbox>
                      </v-col>
                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="Chicken Slices"
                          color="secondary"
                          value="chickenSlices"
                          hide-details
                        ></v-checkbox>
                      </v-col>
                      <v-col cols="12" sm="4" md="4">
                        <v-checkbox
                          v-model="ex4"
                          label="Sausage Slices"
                          color="secondary"
                          value="sausageSlices"
                          hide-details
                        ></v-checkbox>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card-text>
              </v-card>
            </template>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import PizzaCardCustomize from "../components/PizzaCardCustomize.vue";

export default {
  components: { PizzaCardCustomize },
  name: "CustomizePizza",
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
