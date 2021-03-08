import Vue from 'vue'
import Vuex from 'vuex'
import 'es6-promise/auto'

import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import vuetify from './plugins/vuetify';
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
import axios from 'axios';
import store from '../src/Store.js'

// third party addons


Vue.config.productionTip = false

// state management
Vue.use(Vuex , axios )

fetch('/')

new Vue({
  
  el: '#app',
  store , 
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')

