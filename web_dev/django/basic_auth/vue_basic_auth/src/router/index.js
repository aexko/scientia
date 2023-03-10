import { createRouter, createWebHistory } from "vue-router";
// router.beforeEach((to) => {
// 	const store = useStore();
// 	if (to.meta.requiresAuth && !store.isLoggedIn) return "/login";
// });
const routes = [
	{
		path: "/signup",
		name: "SignUp",
		component: () => import("../views/Signup.vue"),
	},
	{
		path: "/login",
		name: "Login",
		component: () => import("../views/Login.vue"),
	},
];

const router = createRouter({
	routes,
	history: createWebHistory(),
});

export default router;
