import Vue from 'vue'
import VueRouter from 'vue-router'
import InsuranceSummary from '../views/InsuranceSummary'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'insuranceSummary',
    component: InsuranceSummary
  },

]

const router = new VueRouter({
  routes
})

export default router
