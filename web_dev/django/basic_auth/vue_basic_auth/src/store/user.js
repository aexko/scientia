import { defineStore } from "pinia";
import { ref } from "vue"

export const useUserStore = defineStore("user", () => {
	const token = ref("");
	const isAuthenticated = ref(false);

	function initializeStore() {
		if (localStorage.getItem("token")) {
			token.value = localStorage.getItem("token");
			isAuthenticated.value = true;
			console.log("OK")
		} else {
			token.value = "";
			isAuthenticated.value = false;
			console.log("OK")

		}
	}

	function setToken(tokenParam) {
		token.value = tokenParam;
		isAuthenticated.value = true;
	}

	function removeToken() {
		token.value = "";
		isAuthenticated.value = false;
	}

	return { token, isAuthenticated, initializeStore, setToken, removeToken };
});
