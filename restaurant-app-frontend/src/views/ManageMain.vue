<template>
  <div>
    <!--  -->
    <div class="row"></div>

    <!-- pagination thing -->

    <div class="row">
      <div class="col-md-3">
        <h3 style="padding-left: 8%; padding-top: 16%; padding-bottom: 3%">
          {{ dishType }} List
        </h3>
        <ul class="list-group" id="tutorials-list">
          <li
            class="list-group-item"
            :class="{ active: count == currentIndex }"
            v-for="(dish, count) in dishes"
            v-bind:key="count"
            @click="setActiveDish(dish, count)"
          >
            {{ dish.dishid }} : {{ dish.dishname }}
          </li>
        </ul>

        <v-pagination
          v-model="page"
          :length="dishcount"
          @input="handlePageChange"
          style="padding-left: 5%; padding-bottom: 3%; margin: 0%; float: left"
        ></v-pagination>
      </div>
      <!--  -->
      <div class="col-md-7">
        <div
          class="row"
          style="padding-left: 2%; padding-right: 5%; padding-top: 5%"
        >
          <sub>Page size</sub>
          <v-select
            v-model="pageSize"
            :items="pageSizes"
            @change="handlePageChange"
          >
          </v-select>
          <sub>Dish Type</sub>
          <v-select
            v-model="dishType"
            :items="dishTypes"
            @change="handleDishChange"
          >
          </v-select>
          <hr style="width: 0%" />
        </div>
        <div v-if="currentDish">
          <div class="col-md-5">
            <h4>Customize {{ dishType }}</h4>
            <!-- ----- -->
            <div>
              <label
                ><strong> {{ dishType }} Name:</strong></label
              >
              <v-text-field
                v-model="currentDish.dishname"
                :value="currentDish.dishname"
              ></v-text-field>
            </div>
            <!-- ----- -->
            <div>
              <label
                ><strong> {{ dishType }} Price:</strong></label
              >
              <v-text-field
                v-model="currentDish.dishprice"
                :value="currentDish.dishprice"
                prefix="LKR"
              ></v-text-field>
            </div>
            <div>
              <label
                ><strong> {{ dishType }} Description:</strong></label
              >
              <v-text-field
                v-model="currentDish.dishdesc"
                :value="currentDish.dishname"
              ></v-text-field>
            </div>
            <!-- ----- -->
            <!-- ----- -->
            <div>
              <label
                ><strong> {{ dishType }} imageLink :</strong></label
              >
              <v-text-field
                v-model="currentDish.dishimg"
                :value="currentDish.dishimg"
              ></v-text-field>
            </div>
            <!-- buttons -->
            <v-btn
              class="btnCustomizePizza"
              color="primary"
              @click="updateDish()"
            >
              Confirm
            </v-btn>
            <v-btn
              class="btnCustomizePizza"
              color="red"
              @click="discardChanges()"
            >
              Discard
            </v-btn>
            <v-btn
              class="btnCustomizePizza"
              color="yellow"
              @click="deleteDishbyID()"
            >
              Delete
            </v-btn>
            <v-btn
              class="btnCustomizePizza"
              color="yellow"
              @click="createDish()"
            >
              Create
            </v-btn>
            <!-- ----- -->
          </div>
        </div>
        <div v-else>
          <br />
          <h2 class="clickOnDish">Please click on a {{ dishType }}</h2>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from 'axios';
import pizzaService from "../services/pizzaService";
import updateService from "../services/updateService";
import deleteService from "../services/deleteService";

export default {
  name: "tutorials-list",

  data: () => ({
    dishes: [],
    dishcount: null,
    currentDish: null,
    currentIndex: -1,
    searchTitle: "",
    page: 1,
    count: 0,
    pageSize: 3,
    pageSizes: [3, 6, 9],
    dishType: "Pizza",
    dishTypes: ["Pizza", "Entree", "Appetizer", "Meal"],
    sortType: "dishid",
    nextIndex: 0,
  }),

  methods: {
    getRequestParams(page, pageSize, sortType, dishType) {
      let params = {};

      // if the field is not null
      if (page) {
        params["page"] = page;
      }

      if (pageSize) {
        params["pageSize"] = pageSize;
      }
      if (sortType) {
        params["sortType"] = sortType;
      }
      if (dishType) {
        params["dishType"] = dishType;
      }
      return params;
    },

    retrieveDishes() {
      const params = this.getRequestParams(
        this.page,
        this.pageSize,
        this.sortType,
        this.dishType
      );

      pizzaService
        .getAllPaginated(params)
        .then((response) => {
          const a = response.data;
          this.dishes = a.content;
          this.count = a.totalElements;
          this.nextIndex = this.dishes[this.dishes.length - 1].dishid
          this.dishcount = Math.ceil(this.count / this.pageSize);
          console.log(this.dishcount)
        })
        .catch((e) => {
          console.log(e);
        });
    },

    handlePageChange(value) {
      this.pageno = value;
      this.currentDish = null;
      this.currentIndex = null;
      this.retrieveDishes();
    },
    handleDishChange(value) {
      this.dishType = value;
      this.currentDish = null;
      this.currentIndex = null;
      this.retrieveDishes();
    },

    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.currentDish = null;
      this.currentIndex = null;
      this.retrieveDishes();
    },

    refreshList() {
      this.retrieveDishes();
      this.currentDish = null;
      this.currentIndex = -1;
    },

    setActiveDish(dish, index) {
      this.currentDish = dish;
      this.currentIndex = index;
    },

    updateDish() {
      const params = this.getRequestParams(
        this.page,
        this.pageSize,
        this.sortType,
        this.dishType
      );
      const currentDish = this.currentDish;

      updateService
        .getUpdatedDish(params, currentDish)
        .then((response) => {
          console.log(response);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    removeAllTutorials() {
      pizzaService
        .deleteAll()
        .then((response) => {
          console.log(response.data);
          this.refreshList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    discardChanges() {
      this.currentDish = null;
      this.currentIndex = null;
    },
    deleteDishbyID() {
      const params = this.getRequestParams(this.dishType);
      const dishid = this.currentDish.dishid;
      console.log(params);
      deleteService.deleteById(params, dishid);
      this.refreshList();
    },
    createDish() {
      const params = this.getRequestParams(this.count); 
     console.log(params.page)
    //  come back to this later
    },
  },

  mounted() {
    this.retrieveDishes();
  },
};
</script>

<style>
.btnCustomizePizza {
  margin-left: 1%;
  align-items: center;
}

.clickOnDish {
  margin-top: 15%;
  margin-left: 28%;
}
</style>