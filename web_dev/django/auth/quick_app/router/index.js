import { createRouter, createWebHistory } from "vue-router";
import Login from '../src/components/Login.vue'
import SignUp from '../src/components/SignUp.vue'


const routes = [
    {
        path: '/sign-up',
        name: 'Sign Up',
        component: SignUp
    },
    {
        path: '/login',
        name: 'Login', 
        component: Login 
    }
]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router