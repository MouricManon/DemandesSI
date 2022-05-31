import { createRouter, createWebHistory } from "vue-router";
import Traitement from "../views/Signaler.vue";
import Demande from "../views/Demande.vue";

const routes = [{
        path: "/signaler",
        name: "Signaler",
        component: Demande,
    },
  
    {
        path: "/traitement",
        name: "Traitement",
        component: Traitement,
    },
    {
        path: "/",
        name: "Choix",
        component: Choix,
    },

  
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
