import { createRouter, createWebHistory } from "vue-router";
import Demande from "../views/Demande.vue";
import Resoudre from "../views/Resoudre.vue";
import Accueil from "../views/Accueil.vue";
const routes = [{
        path: "/signaler",
        name: "Signaler",
        component: Demande,
    },
  
    {
        path: "/traitement",
        name: "Traitement des demandes",
        component: Resoudre,
    },
    {
        path: "/",
        name: "Accueil",
        component: Accueil,
    },

  
 /* {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import( webpackChunkName: "about" "../views/About.vue"),
  }, */
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
