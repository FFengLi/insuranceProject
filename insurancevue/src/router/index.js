import Vue from 'vue'
import VueRouter from 'vue-router';
import Transfer from "@/views/Transfer.vue";
import Insurance from "@/views/Insurance.vue";
import CreateInsurance from "@/components/CreateInsurance.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/insurance',
        component: Insurance
    },
    {
        path: '/transfer',
        component: Transfer
    },
    {
        path: '/createInsurance',
        component: CreateInsurance
    }
]

const router = new VueRouter({
  routes
})

export default router
