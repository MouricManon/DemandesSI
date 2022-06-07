<script setup>
import { onMounted, reactive, onUpdated } from "vue";
import Demande from "@/Demande.js";
import CreationDemande from "@/components/CreationDemande.vue";
onMounted(() => {
  getDemandes();
});
const data = reactive({
    id: "",
    demandes: [],
  
});

function getDemandes(event) {
  let url = "/api/demandes";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => response.json())
    .then((json) => {
      let results = json._embedded.demandes;
      results.forEach((v) => data.demandes.push(v));
    })
    .catch((error) => alert(error));
    console.log(data.demandes);
}


</script>
<template>
 <div class="container bg-gradient-bleufonce rounded-3">
   <p>Vous avez {{data.demandes.length}} demande(s) à traiter.</p>
   <table>
                        <thead><tr>
                                <th class="date">Date</th>
                                <th class="nom">Nom</th>
                                <th class="prenom">Prenom</th>
                               <th class="objet">Objet</th>
                                   <th class="profession">Profession</th>
                              <th class="demande">Voir</th>
                              <th class="traite">Traité</th>
      
                            </tr>
                        </thead>
                        <tbody  class="txt-violet">
                            <tr v-if="data.demandes.length != 0" v-for="demande in data.demandes">
                                <td class="date">{{ demande.dateCreation }}</td>
                                <td class="nom">{{ demande.nomdemandeur }}</td>
                                <td class="prenom">{{ demande.prenomdemandeur }}</td>
                                <td>{{ demande.objet }}</td>
                                <td class="info">{{ demande.profession }}</td> 
                                <td class="voir">
                                    <a href="/Voir" class="text-decoration-none txt-bleufonce" @click="$emit('laDemandeid', id)"> Voir</a>
                                </td>       
                                <td>
                                <input id="bouton" type="button" value="réalisé"/>   </td>           
                            </tr>
                            
                            <tr v-else>
                                <td colspan="10">
                                    Vous n'avez aucune demande dans votre liste. Vous pouvez en ajouter dans la page
                                    <a href="/Signaler" class="text-decoration-none txt-bleufonce"> Création demande</a>
                                </td>
                            </tr>
                        </tbody>
                           </table>
                </div>
</template>
<style>
#bouton{
  cursor : pointer;
    color: black;
  border: 1px solid #000000;
  border-radius: 5px;
  background: white;
  width : 70px;
}
</style>
<!--Case : Tableau <template>
    <div class="tableau">
      <h2>Liste des médicaments en cours d'ajout</h2>

      <table border="1" id="leTableau" class="table table-bordered table-sm table-hover">
        <thead>
          <tr>
            <th colspan="4" id="liste">
              Liste de vos médicaments en cours de saisie
            </th>
            <th id="action">Réécrire une saisie</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(ceTraitement, index) in listTraitement" :key="index">
            <td id="1">
              nomdemandeur du médicament : <br />
              Maladie traité :
            </td>
            <td id="2">
              {{ ceTraitement._medic }} <br />
              {{ ceTraitement._maladie }}
            </td>
            <td id="3">
              Durée de prise : <br />

              Fréquence de prise : <br />

              Quantité à prendre :
            </td>
            <td id="4">
              {{ ceTraitement._duree }} {{ ceTraitement._unitduree }} <br />

              {{ ceTraitement._freq }} / {{ ceTraitement._unitfreq }} <br />

              {{ ceTraitement._qte }} / Prise<br />
            </td>
          </tr>
        </tbody>
      </table>

    
      <input type="button" id="enregistrer" value="Valider la liste et l'enregistrer" @click="putDemande()" />
    </div>
  </div></template>
  function getFrequence(event) {
  let url = "/api/allUniteFreq";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      dataJSON.forEach((v) => listeunitFreq.push(v));
    })
    .catch((error) => { });
}

function getDuree(event) {
  let url = "/api/allUniteDuree";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      dataJSON.forEach((v) => listeunitDuree.push(v));
    })
    .catch((error) => { });
}*/-->  
   <!-- Bouton -->