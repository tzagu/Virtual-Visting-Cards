// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vuetify from '@/plugins/vuetify'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import VueSweetalert2 from 'vue-sweetalert2'

Vue.use(Vuex);
Vue.use(VueSweetalert2);

const store = new Vuex.Store({
  plugins: [createPersistedState({storage: window.sessionStorage, paths: ['user', 'allItemPersonCards']})],
  state: {
    count: 0,
    user: {
      id: 0,
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

    filter: {
      filtered: false,
      location: "",
      item: "",
      minPrice: 0,
      maxPrice: 0,
      partnerType: "",
    },

    categoryItems: [],

    allItemPersonCards: [],

    cardData: {
      id: 0,
    },

  },
  mutations: {
    increment(state) {
      state.count++
    },
    setName(state, payload) {
      state.user.name = payload
    },
    setEmail(state, payload) {
      state.user.email = payload
    },
    setUserId(state, payload) {
      state.user.id = payload
    },
    setUser(state, payload){
      state.user.name = payload.name
      state.user.email = payload.email
      state.user.id = payload.id
      state.user.mobile1 = payload.mobile1
      state.user.mobile2 = payload.mobile2
      state.user.address = payload.address
      state.user.landline = payload.landline
      state.user.joinedDate = payload.joinedDate
      state.user.status = payload.status
    },
    setCardId(state, payload) {
      state.cardData.id = payload
    },
    setCategoryItems(state, payload) {
      state.categoryItems.push(payload)
    },
    setAllItemPersonCards(state, payload) {
      state.allItemPersonCards.push(payload)
    },
    setFilterStatus(state, payload){
      state.filter.filtered = payload
    },
    setFilter(state, payload){
      state.filter.filtered = payload[0].filtered
      state.filter.location = payload[0].filterLocation
      state.filter.item = payload[0].filterItem
      state.filter.minPrice = payload[0].filterMinPrice
      state.filter.maxPrice = payload[0].filterMaxPrice
      state.filter.partnerType = payload[0].filterPartnerType
    },

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
  store,
})
