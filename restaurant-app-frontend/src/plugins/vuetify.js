import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#311b92',
        secondary: '#424242',
        accent: '#82B1FF',
        error: '#e2293f',
        info: '#2196F3',
        success: '#41c485',
        warning: '#f38404',
        // added by me
        black: "#1d1c1c"
      },
    },
  },
});
