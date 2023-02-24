<template>
  <main>
    <!-- heading -->
    <header></header>

    <nav class="filter">
      <button @click="filter = 'all'">All tasks</button>
      <button @click="filter = 'completed'">Completed tasks</button>
    </nav>
    <h1>You have {{ taskStore.totalCount }} tasks in total</h1>

    <div class="task-list" v-if="filter === 'all'">
      <div v-for="task in taskStore.tasks">
        <TaskDetails :task="task" />
      </div>
    </div>

    <div class="task-list" v-if="filter === 'completed'">
      <h1>tasks completed</h1>
      <h2>you have {{ taskStore.completedCount }}</h2>
      __________
      <div v-for="task in taskStore.completed">
        <TaskDetails :task="task" />
      </div>
    </div>
  </main>
</template>

<script>
import TaskDetails from './components/TaskDetails.vue'
import { useTaskStore } from './stores/TaskStore'
import { ref } from 'vue'

export default {
  components: { TaskDetails },
  setup() {
    const taskStore = useTaskStore()

    const filter = ref('all')

    return {
      taskStore,
      filter
    }
  }
}
</script>
