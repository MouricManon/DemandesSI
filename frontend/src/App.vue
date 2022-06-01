<script setup>
import CreationDemande from "@/components/CreationDemande.vue";
import Header from "@/components/1Header.vue";
import Footer from "@/components/2Footer.vue";
</script>




<template>
  <div id="header">
    <Header>
</Header></div>
  <div id="footer"><Footer></Footer></div>
</template>

<style>
#app {
  font-family:Arial, Avenir, Helvetica,  sans-serif;
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
