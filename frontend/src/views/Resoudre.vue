<script setup>
import TableauDemande from "@/components/TableauDemande.vue";
import { json } from "body-parser";
import VoirDemande from "@/components/VoirDemande.vue";
let touteDemande = ref(true)

</script>
<template>


  <div class="espace" @FetchFaire="handler">

    <div v-if="touteDemande">

      <div @click="touteDemande = !touteDemande">
        <TableauDemande>
        </TableauDemande>
      </div>
    </div>
    <div v-else>
      <div @click="touteDemande = !touteDemande">
        <VoirDemande></VoirDemande>
      </div>
    </div>
  </div>



</template>
