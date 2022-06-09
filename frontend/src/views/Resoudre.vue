<script setup>
import TableauDemande from "@/components/TableauDemande.vue";
import { json } from "body-parser";
import VoirDemande from "@/components/VoirDemande.vue";
/*
function handler(id){
  let fetchOptions={method:"GET"};
  fetch("api/api/demandes/"+id)
  .then((response)=> response.json())
  .then((json)=>{
    let results=json._embedded.demandes,
    results.forEach(v)=>data.demandes.push(v),

    console.log(json), 
  })
}*/
</script>
<template>
  
  <div class="espace" @laDemandeid="handler" >
<TableauDemande>
</TableauDemande>

</div>

</template>
