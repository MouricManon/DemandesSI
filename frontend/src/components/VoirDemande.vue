<script setup>
import { onMounted, reactive, onUpdated } from "vue";
import Demande from "@/Demande.js";
import CreationDemande from "@/components/CreationDemande.vue";
onMounted(() => {
 // laDemandeid();
});
/*
const data = reactive({ 
});


function laDemandeid(id) {
  let fetchOptions = { method: "GET" };
  fetch("/api/medicamentsById?id=" + id)
    .then((response) => {
      return response.json();
    })
     .then((dataJSON) => {
      return dataJSON ;
    })
    .catch((error) => { }); console.log(response);
}

*/

</script>
<template>
 <div class="container">
   <table class="table">
      <thead><tr class="date">Date
        </tr>
        <tr class="urgence">Urgence
        </tr>
        <tr class="nom">Nom 
        </tr>
        <tr class="prenom">Prénom
        </tr>
        <tr class="objet">Objet
        </tr>
        <tr class="pb">Problème
        </tr>
        <tr class="profession">Profession
        </tr>
        <tr class="photo">Photo
        </tr>
        <tr class="adressemail">Adresse mail
        </tr>
        <tr class="traite">Traité?
        </tr>
      </thead>
      <tbody  class="txt-violet">
      </tbody>
    </table>
  </div>
</template>
