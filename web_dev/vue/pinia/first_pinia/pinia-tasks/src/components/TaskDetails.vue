<template>
  <div class="task">
    <h3>{{ task.title }}</h3>
    <button @click="taskStore.deleteTask(task.id)">delete</button>
    <button @click="taskStore.toggleCompleted(task.id)">completed</button>
  </div>
</template>

<script>
import { useTaskStore } from '../stores/TaskStore'
export default {
  props: ['task'],
  setup() {
    const taskStore = useTaskStore()
    
      
    return { taskStore}
  }
}
</script>
