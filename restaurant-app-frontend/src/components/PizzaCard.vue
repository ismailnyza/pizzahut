<template>
    <div class="card" v-bind:id="dishID" style="width: 18rem">
      <img
        class="card-img-top"
        v-bind:src="imageLink"
        v-bind:alt="dishName"
      />
      <div class="card-body">
        <h5 class="card-title">{{dishName}}</h5>
        <p class="card-text">
          
        </p>
      </div>
        <li class="list-group-item">{{dishDescription}}</li>
        <li class="list-group-item">{{dishPrice}}</li>
        <a href="#" class="btn btn-primary">Add to Order</a>
    </div>
</template>

<script>
export default {
  name: "PizzaCard",
    props: {
      imageLink: String ,
      dishID: String ,
      dishName : String,
      dishDescription : String,
      dishPrice :String 
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
