<template>
  <div class="hello">
    <div class="contianer">
      <div class="row">
        <div class="col-3">
          <!-- naming convention for boxes B x axis then y axis -->
          <h1 class="font text-left" id="B00">
            We have the Freshest Ingredients with the Best Recipie
            <br />
            <span class="tagline-text">
              Just visit our Restaurants or order online
            </span>
            <br />
            <v-btn
              elevation="2"
              class="btn-about-component"
              to="/Order"
              >View Menu</v-btn
            >
            <v-btn
              elevation="2"
              class="btn-about-component"
              to="/Restaurants"
              >View Restaurants</v-btn
            >
          </h1>
          <!-- should be replaced -->
          <br/><br /><br /><br /><br /><br /><br /><br /><br />
          <br />
        </div>
        <div class="col-7" id="B01">
          <v-img contain src="..\assets\aboutUsImage.png" id="imgB01"></v-img>
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
#B00 {
  padding: 45% 5% 25% 5%;
  font-weight: 300;
  line-height: 160%;
  /* if needed */
  border-radius: 1.33%;
  color: #41c485;
}

#imgB01 {
  height: 70%;
  padding: 0% 0% 0% 0%;
  margin: 5%;
}

.B03 {
  font-size: 150%;
  font-weight: 300;
}

.B03Card {
  background-color: transparent;
  font-weight: 300;
}

.B04CardStack {
  padding-top: 28%;
}

.hello {
  padding: 1%;
  background-color: #1d1c1c;
}

.tagline-text {
  color: white;
  font-size: 65%;
}

.btn-about-component {
  font-size: 100%;
  padding: 5%;
  padding-left: 20.4%;
  padding-right: 21%;
  background-color: #41c485;
  color: white;
  font-weight: 300;
}
</style>
