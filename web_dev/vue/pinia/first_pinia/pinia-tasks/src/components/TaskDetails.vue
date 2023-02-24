<template>
  <div class="task">
    <h3>{{ task.title }}</h3>
    <button>favorite</button>
    <button>delete</button>
  </div>
</template>

<script>
export default {
  props: ['task']
}
</script>
