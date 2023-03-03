import { createApp } from 'vue'
import App from './App.vue'
// pinia
import { createPinia } from 'pinia'
// router
import { createRouter, createWebHistory } from "vue-router";

import './assets/main.css'
import router from '../router/index.js'
import axios from 'axios'

axios.defaults.baseURL = 'http://127.0.0.1/8000/'

const pinia = createPinia()
createApp(App)
.use(pinia)
.use(router,axios,)
.mount('#app')
