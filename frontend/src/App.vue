<<<<<<< Updated upstream
<template>
  <div>
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/countries">Les pays</router-link> |
      <router-link to="/countryEdit">Edition pays</router-link> |
      <router-link to="/cityEdit">Edition villes</router-link> |
      <router-link to="/cityByCountry">Villes par pays</router-link> |
      <router-link to="/about">About</router-link> |
      <router-view />
    </div>
  </div>
=======
<script setup>
import CreationDemande from "@/components/CreationDemande.vue";
import Header from "@/components/1Header.vue";
import Footer from "@/components/2Footer.vue";
</script>




<template>
  <div>
    <Header>
</Header>

  </div><Footer></Footer>
>>>>>>> Stashed changes
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #b9b9b9;
}
</style>
