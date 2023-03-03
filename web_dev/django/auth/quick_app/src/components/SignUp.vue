<script>
import axios from 'axios'

export default {
  name: 'SignUp',
  data() {
    return {
      username: '',
      password: ''
    }
  },

  methods: {
    submitForm() {
      const formData = {
        username: this.username,
        password: this.password
      }

      axios
        .post('api/v1/users/', formData)
        .then((response) => {
          this.$router.push('/login')
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>

<template>
  <main>
    <h1>sigup</h1>
    <form @submit.prevent="submitForm">
      <input type="text" v-model="username" placeholder="username" />
      <input type="password" v-model="password" placeholder="password" />
      <input type="submit" value="submit" />
    </form>
  </main>
</template>
