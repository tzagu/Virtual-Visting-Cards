import Vue from 'vue'
import Router from 'vue-router'
import SignUp from '@/components/SignUp.vue'
import Login from '@/components/Login.vue'
import CreateProfile from '@/pages/CreateProfile.vue'
import ItemPersonCards from '@/components/ItemPersonCards.vue'
import Filter from '@/pages/Filter.vue'
import CardClicked from '@/pages/CardClicked.vue'
import MyDeals from '@/pages/MyDeals.vue'
import ContactUs from '@/components/ContactUs.vue'


Vue.use(Router)

export default new Router({
  
  routes: [
    {
      path: '/',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/itempersoncards',
      name: 'ItemPersonCards',
      component: ItemPersonCards
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/createprofile',
      name: 'CreateProfile',
      component: CreateProfile
    },
    {
      path: '/filter',
      name: 'Filter',
      component: Filter
    },
    {
      path: '/partner',
      name: 'CardClicked',
      component: CardClicked
    },
    {
      path: '/mydeals',
      name: 'MyDeals',
      component: MyDeals
    },
    {
      path: '/contactus',
      name: 'ContactUs',
      component: ContactUs
    },

  ]
})
