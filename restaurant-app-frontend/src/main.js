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


Vue.config.productionTip = false

// state management
Vue.use(Vuex , axios )

const store = new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    increment (state) {
      state.count++
    }
  }
})


new Vue({
  
  el: '#app',
  store , 
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
