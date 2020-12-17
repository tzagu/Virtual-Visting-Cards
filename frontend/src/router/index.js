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
import EditProfile from '@/pages/EditProfile.vue'
import AddItems from '@/admin/AddItems.vue'
import GetVip from '@/pages/GetVip.vue'
import ForgotPassword from '@/pages/ForgotPassword.vue'
import ResetForm from '@/pages/bcard-pwr-secure/eb-caroli-resetvalidate/user-form.vue'
import Tour from '@/pages/Tour.vue'
import VIPInfo from '@/pages/VIP-Info'
import AdminHome from '@/admin/AdminHome'
import store from "@/main.js"


Vue.use(Router)

const router = new Router({
  
  routes: [
    {
      path: '/',
      name: 'SignUp',
      component: SignUp,
      meta: {
        allowAnonymous: true
      }
    },
    {
      path: '/itempersoncards',
      name: 'ItemPersonCards',
      component: ItemPersonCards,
      meta: {
        allowAnonymous: true
      }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        allowAnonymous: true
      }
    },
    {
      path: '/createprofile',
      name: 'CreateProfile',
      component: CreateProfile,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/filter',
      name: 'Filter',
      component: Filter,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/partner',
      name: 'CardClicked',
      component: CardClicked,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/mydeals',
      name: 'MyDeals',
      component: MyDeals,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/contactus',
      name: 'ContactUs',
      component: ContactUs,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/editprofile',
      name: 'EditProfile',
      component: EditProfile,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/additems',
      name: 'AddItems',
      component: AddItems,
      meta: {
        allowAnonymous: false,
        requireAdmin: true
      }
    },
    {
      path: '/getvip',
      name: 'GetVip',
      component: GetVip,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/forgotpassword',
      name: 'ForgotPassword',
      component: ForgotPassword,
      meta: {
        allowAnonymous: true
      }
    },
    {
      path: '/bcard-pwr-secure/eb-caroli-resetvalidate/user-form',
      name: 'ResetForm',
      component: ResetForm,
      meta: {
        allowAnonymous: true
      }
    },
    {
      path: '/tour',
      name: 'Tour',
      component: Tour,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/vip',
      name: 'VIPInfo',
      component: VIPInfo,
      meta: {
        allowAnonymous: false
      }
    },
    {
      path: '/admin/tzagu/iservetheworld/withlove',
      name: 'AdminHome',
      component: AdminHome,
      meta: {
        allowAnonymous: false,     
        requireAdmin: true
      }
    },
  ],
  
})

router.beforeEach((to, from, next) => {
  if(to.meta.requireAdmin){
    if(store.state.user.email === "tzaguyapa@gmail.com"){
      next()
    }
    else{
      next("/login")
    }
  }
  else{
    if(!to.meta.allowAnonymous){
      if(!store.state.user.email){
        next("/login")
      }
    }
    else{
      next()
    }
  }
})

export default router;


