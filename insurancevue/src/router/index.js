import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from "@/components/Index.vue";
import Header from "@/components/index/Header.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/main',
        name: 'main',
        component: Main
    },
    {
        path: '/head',
        name:'head',
        component: Header
    }
]

const router = new VueRouter({
  routes
})

export default router
