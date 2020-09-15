import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import SignUp from '@/pages/SignUp.vue'
import ItemPersonCards from '@/components/ItemPersonCards.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/helloworld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/itempersoncards',
      name: 'ItemPersonCards',
      component: ItemPersonCards
    }
  ]
})
