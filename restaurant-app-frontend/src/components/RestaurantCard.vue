<template>
    <div class="card" v-bind:id="RestaurantID" style="width: 18rem">
      <img
        class="card-img-top"
        v-bind:src="imageLink"
        v-bind:alt="dishName"
      />
      <div class="card-body">
        <h5 class="card-title">{{RestaurantName}}</h5>
        <hr>
        <p class="card-text">
            {{RestaurantAddress}}
          
        </p>
      </div>    
    </div>
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
