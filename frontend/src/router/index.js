import Vue from 'vue'
import Router from 'vue-router'
import SignUp from '@/pages/SignUp.vue'
import Login from '@/pages/Login.vue'
import CreateProfile from '@/pages/CreateProfile.vue'
import ItemPersonCards from '@/components/ItemPersonCards.vue'
import Filter from '@/pages/Filter.vue'
import CardClicked from '@/pages/CardClicked.vue'


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
    }

  ]
})
