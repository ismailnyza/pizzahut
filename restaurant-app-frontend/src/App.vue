<template>
  <div id="app">
    <nav class="navbar sticky-top navbar-expand-lg navbar-dark ">
      <a class="navbar-brand" href="/">Pantheons Pizza</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto pr-4 ">
          
          <li class="nav-item">
            <a class="nav-link" href="/Restaurants"
              >Restuarants <span class="sr-only"></span></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/Promotions"
              >Promotions <span class="sr-only"></span></a
            >
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/Order"
              >Order Online <span class="sr-only"></span></a
            >
          </li>
          <!-- needs to be moved to the right -->
          <li class="nav-item " id="navbutton">
            <a class="btn btn-primary" href="/Cart" role="button">Cart</a>
          </li>
          </ul>
        
      </div>
    </nav>
    <router-view></router-view>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

.navbar {
  background-color: #002447;

}
.nav-link {
  color: #79c5e7;
  
}
.nav-link:hover{
  color: #fffaf7;
}


.vl {
  border-left: 6px solid green;
  height: 500px;
  position: absolute;
  left: 50%;
  margin-left: -3px;
  top: 0;
}


</style>
