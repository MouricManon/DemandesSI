<script setup>
import { onMounted, reactive, onUpdated } from "vue";
import Demande from "@/Demande.js";
import CreationDemande from "@/components/CreationDemande.vue";
onMounted(() => {
  laDemandeid();
});

const data = reactive({
  
});
function laDemandeid(id) {
  let fetchOptions = { method: "GET" };
  fetch("/api/medicamentsById/" + id)
    .then((response) => {
      return response.json();
    })
     .then((dataJSON) => {
      return dataJSON ;
    })
    .catch((error) => { }); console.log(response);
}
</script>
<template>
<h4>bonjour</h4>
</template>