import Vue from 'vue'
import VueRouter from 'vue-router';
import Transfer from "@/views/Transfer.vue";
import Insurance from "@/views/Insurance.vue";
import CreateInsurance from "@/components/CreateInsurance.vue";
import InsuranceSummary from "@/views/InsuranceSummary";
import UpdateInsurance from "@/components/UpdateInsurance.vue";

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
    },
    {
        path: '/insuranceSummary',
        component: InsuranceSummary
    },
    {

        path: '/updateInsurance',
        component: UpdateInsurance
    }
]

const router = new VueRouter({
  routes
})

export default router
