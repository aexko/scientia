import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router/index"
import { createPinia } from 'pinia'
import { useUserStore } from './store/user'

const pinia = createPinia()


createApp(App)
.use(pinia)
.use(router)
.mount('#app')

const userStore = useUserStore()
