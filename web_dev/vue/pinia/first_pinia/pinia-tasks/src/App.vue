<template>
  <main>
    <!-- heading -->
    <header></header>

    <nav class="filter">
      <button @click="filter = 'all'">All tasks</button>
      <button @click="filter = 'completed'">Completed tasks</button>
    </nav>
    <h1>You have {{ totalCount }} tasks in total</h1>

    <!-- loading  -->
    <div class="loading" v-if="loading">Loading tasks...</div>

    <div class="new-task-form">
      <TaskForm />
    </div>
    <div class="task-list" v-if="filter === 'all'">
      <div v-for="task in tasks">
        <TaskDetails :task="task" />
      </div>
    </div>

    <div class="task-list" v-if="filter === 'completed'">
      <h1>tasks completed</h1>
      <h2>you have {{ completedCount }}</h2>
      __________
      <div v-for="task in completed">
        <TaskDetails :task="task" />
      </div>
    </div>

    <button @click="taskStore.$reset">reset state</button>
  </main>
</template>

<script>
import TaskDetails from './components/TaskDetails.vue'
import TaskForm from './components/TaskForm.vue'
import { useTaskStore } from './stores/TaskStore'
import { ref } from 'vue'
import { storeToRefs } from 'pinia'

export default {
  components: { TaskDetails, TaskForm },
  setup() {
    const taskStore = useTaskStore()

    const { tasks, loading, completed, completedCount, totalCount } = storeToRefs(taskStore)

    // fetch tasks
    taskStore.getTasks()

    const filter = ref('all')

    return {
      taskStore,
      filter,
      tasks,
      loading,
      completed,
      completedCount,
      totalCount
    }
  }
}
</script>
