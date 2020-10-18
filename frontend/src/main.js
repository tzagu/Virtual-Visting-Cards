// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vuetify from '@/plugins/vuetify'
import Vuex from 'vuex'

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    count: 0,
    user: {
      name: "",
      mobile1: "",
      mobile2: "",
      landline: "",
      joinedDate: "",
      email: "",
      address: "",
      dealCount: 0,
      status: ""
  },
    cardData: [],
  },
  mutations: {
    increment (state) {
      state.count++
    },
    setName(state, payload){
      state.user.name = payload
    }
  },
  getters: {},
  actions: {}
})
new Vue({
  el: '#app',
  router,
  vuetify,
  components: { App },
  template: '<App/>',
  store
})
