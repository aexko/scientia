import { defineStore } from 'pinia'

export const useTaskStore = defineStore('taskStore', {
  state: () => ({
    tasks: [
      // ici axios
      { id: 1, title: 'Task 1', completed: false },
      { id: 2, title: 'Task 2', completed: true },
      { id: 3, title: 'Task 3', completed: false },
      { id: 4, title: 'Task 4', completed: true },
      { id: 5, title: 'Task 5', completed: false },
      { id: 6, title: 'Task 6', completed: true }
    ],
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
  }
})
