import { defineStore } from 'pinia'

export const useTaskStore = defineStore('taskStore', {
  state: () => ({
    tasks: [
      // ici axios
    ],
    loading: false,
    name: 'un truc random on peut add'
  }),
  getters: {
    completed() {
      // this refer to the state object
      return this.tasks.filter((t) => t.completed)
    },
    completedCount() {
      return this.tasks.reduce((previousValue, currentValue) => {
        return currentValue.completed ? previousValue + 1 : previousValue
      }, 0)
    },
    totalCount: (state) => {
      return state.tasks.length
    }
  },
  actions: {
    async getTasks() {
      this.loading = true
      const res = await fetch('http://localhost:3000/tasks')
      const data = await res.json()
      this.tasks = data
      this.loading = false
    },

    async addTask(task) {
      this.tasks.push(task)
      const res = await fetch('http://localhost:3000/tasks', {
        method: 'POST',
        body: JSON.stringify(task),
        headers: { 'Content-Type': 'application/json' }
      })

      if (res.error) {
        console.log(res.error)
      }
    },
    async deleteTask(id) {
      this.tasks = this.tasks.filter((t) => {
        return t.id !== id
      })

      const res = await fetch('http://localhost:3000/tasks/'+ id, {
        method: 'DELETE',
      })

      if (res.error) {
        console.log(res.error)
      }

    },
    async toggleCompleted(id) {
      const task = this.tasks.find((t) => t.id === id)
      task.completed = !task.completed

      const res = await fetch('http://localhost:3000/tasks/'+ id, {
        method: 'PATCH',
        body: JSON.stringify({ completed: task.completed}),
        headers: { 'Content-Type': 'application/json' }
      })

      if (res.error) {
        console.log(res.error)
      }

    }
  }
})
