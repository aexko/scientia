const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'mjnehj',
  e2e: {
    baseUrl: "http://127.0.0.1:3000",
  },

  component: {
    devServer: {
      framework: "vue",
      bundler: "webpack",
    },
  },
});
