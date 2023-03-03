<script setup></script>

<template>
  <header></header>

  <main>
    <div class="nav">
      <RouterView />
    </div>
  </main>
</template>

<script>
import axios from 'axios'
import { useUserStore } from '../store/UserStore'
export default {
  setup() {
    const userStore = useUserStore()
    const token = userStore.state.token
    if (token) {
      axios.defaults.headers.common['Authorization'] = token
    } else {
      axios.defaults.headers.common['Authorization'] = ''
    }
  }
}
</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
