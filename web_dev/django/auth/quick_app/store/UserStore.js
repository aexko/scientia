import { defineStore } from 'pinia'

export const useUserStore = defineStore({
  state: () => ({
    token: '',
    isAuthentificated: false
  }),

  actions: () => ({
    setToken(token) {
      this.token = token
      this.isAuthentificated = true
    },
    logout() {
      this.token = ''
      this.isAuthentificated = false
    },
    initializeStore(state) {
      const token = localStorage.getItem('token')
      if (token) {
        state.token = token
        state.isAuthentificated = true
      } else {
        state.token = ''
        state.isAuthentificated = false
      }
    }
  })
})
