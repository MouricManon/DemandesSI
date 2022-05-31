<template>
  
    
  <div class="navbar mb-3">



    <nav class="container navbar-expand-lg d-flex justify-content-md-between py-3 mb-4 border-bottom">
      <router-link to="/signaler" class="navbar-brand"><span class="max">Demande</span></router-link>
      <router-link to="/traitement" class="navbar-brand"><span class="max">Traitement</span></router-link>
      <p class="mt-3">Bienvenue</p>
    </nav>
  </div>
  <router-view />
</template>



<style scoped>

.navbar {
  background: -webkit-linear-gradient(to right, #838383, #c7c7c7);
  background: linear-gradient(to right, #c7c7c7, #838383);
}

.max {
  font-size: 1.6em;
  margin-top: 20px;
}

.navbar-brand:hover {
  color: #5F4850;
}

p {
  color: black;
}
</style>