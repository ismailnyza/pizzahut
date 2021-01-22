<template>
  <div class="hello">
    <div class="contianer">
      <div class="row">
        <div class="col-6 mx-auto">
          <img
            src="..\assets\backgroundimage1.jpg"
            class="img-fluid float-left"
          />
        </div>
      </div>
      <div class="row">
        <div class="col-6 mx-auto">
          <br />
          <h5 class="font-italic">
            Our pizza is made with the freshest ingredients and a secret recipie
            preserved by the pantheon family for generations
          </h5>
          <br />
          
          <a class="btn btn-dark btn-block" href="/Order">
            Order Now !
          </a>
          <a class="btn btn-dark  btn-block" href="/Restaurants">
            View Our Restautants
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUsComp",
};
</script>

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

.btn{
  background-color: #002447;
}
</style>
