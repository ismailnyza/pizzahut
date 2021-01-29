<template>
  <div class="hello">
    <div class="contianer">
      <div class="row">
        <div class="col-5 mx-auto" id="panthImage">
          <img
            src="..\assets\backgroundimage1.jpg"
            class="img-fluid float-left"
          />
        </div>
      </div>
      <div class="row">
        <div class="col-6 mx-auto">
          <br />
          <h5 class="font-italic text-center">
            Our pizza is made with the freshest ingredients and a secret recipie preserved by the pantheon family for generations
          </h5>
          <br />

          <v-btn color="error" block elevation="1" raised rounded to="/Order">  Order Now !</v-btn>
          <br>
          <v-btn color="error" block elevation="1" raised rounded to="/Order">  Visit Us</v-btn>
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
#panthImage{
  margin-top: 2.5%;
}
.container{
  background-image: url("https://wallpaperaccess.com/full/1908942.jpg");
}
</style>
