<template>
  <div>
    <div class="container" id="dishes">
      <h2>All Dishes</h2>
      <!-- ------ -->
      <v-data-table :headers="headers" :items="dishes" sort-by="dishid">
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Edit Dishes</v-toolbar-title>
            <v-divider class="mx-4" inset vertical></v-divider>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="500px">
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  color="primary"
                  dark
                  class="mb-2"
                  v-bind="attrs"
                  v-on="on"
                >
                  New Item
                </v-btn>
              </template>
              <v-card>
                <!-- card to show the edited item -->
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.dishname"
                          label="Dish Name"
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field
                          v-model="editedItem.dishprice"
                          label="Dish Price"
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="12" md="8">
                        <v-text-field
                          v-model="editedItem.dishdesc"
                          label="Dish Description"
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="12" md="8">
                        <v-text-field
                          v-model="editedItem.dishimg"
                          label="Dish Image Link"
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <!-- this should be made disabled -->
                        <v-text-field
                          v-model="editedItem.dishid"
                          label="dishID"
                        ></v-text-field>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card-text>

                <!-- --------------- -->
                <!-- this should be added to the table  -->
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="close">
                    Cancel
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="save"> Save </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-dialog v-model="dialogDelete" max-width="500px">
              <v-card>
                <v-card-title class="headline"
                  >Are you sure you want to delete this item?</v-card-title
                >
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="closeDelete"
                    >Cancel</v-btn
                  >
                  <v-btn color="blue darken-1" text @click="deleteItemConfirm"
                    >OK</v-btn
                  >
                  <v-spacer></v-spacer>
                </v-card-actions>
                <!-- --------------- -->
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>
        <!-- crud operations -->
        <!-- why does this show a bug idk man -->
        <template v-slot:item.actions="{ item }">
          <v-icon small class="mr-2" @click="editItem(item)">
            mdi-pencil
          </v-icon>
          <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
        </template>
        <template v-slot:no-data>
          <v-btn color="primary" @click="initialize"> Reset </v-btn>
        </template>
      </v-data-table>
      <v-btn @click="confirmChanges()">Confirm Changes </v-btn>
      <v-btn @click="discardAllChanges()">Discard All Changes </v-btn>
      <!-- ------ -->
    </div>
  </div>
</template>

<script>
export default {
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "DishID", value: "dishid" },
      { text: "Dish Name", value: "dishname" },
      { text: "Dish Price", value: "dishprice", sortable: false },
      { text: "Dish Description", value: "dishdesc", sortable: false },
      { text: "Actions", value: "actions", sortable: false },
    ],
    dishes: [],

    editedIndex: -1,
    editedItem: {
      dishid: "",
      dishname: "",
      dishdesc: "",
      dishimg: "",
      dishprice: "",
    },
    defaultItem: {
      dishid: "",
      dishname: "",
      dishdesc: "",
      dishimg: "",
      dishprice: "",
    },
  }),

  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },
  // this line doesnt run it should be fixed
  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      this.dishes = this.$store.state.dishes;
    },

    editItem(item) {
      this.editedIndex = this.dishes.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      this.editedIndex = this.dishes.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.dishes.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.dishes[this.editedIndex], this.editedItem);
      } else {
        this.dishes.push(this.editedItem);
      }
      this.close();
    },

    confirmChanges() {
      //Doesnt update the data locally it should lets fix that it should update the back end not the front end lol
      this.$store.dispatch("postDishes")
      console.log("dishes Have Been Updated")
      
    }
  },
};
</script>

<style>
</style>