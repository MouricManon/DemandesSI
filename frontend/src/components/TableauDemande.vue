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
      results.forEach((v) => demandes.push(v));
    })
    .catch((error) => alert(error));
    console.log(demandes);
}



</script>
<template>
 <div class="container bg-gradient-bleufonce rounded-3">
   <table>
                        <thead><tr>
                                <th class="date">Date de la demande</th>
                                <th class="nom">Nom</th>
                                <th class="prenom">Prenom</th>
                               <th class="objet">Objet</th>
                                   <th class="profession">Profession</th>
                              <th class="demande">Voir</th>
                              <th class="traite">Traité</th>
      
                            </tr>
                        </thead>
                        <tbody  class="txt-violet">
                            <tr v-if="demandes.length != 0" v-for="demande in demandes">
                                <td class="date">{{ demande.getDatecreation() }}</td>
                                <td class="nom">{{ demande.getNomDemandeur() }}</td>
                                <td class="prenom">{{ demande.getPrenomDemandeur() }}</td>
                                <td>{{ demande.getObjet() }}</td>
                                <td class="info">{{ demande.getPb() }}</td> 
                                <td colspan="10">
                                  Cliquez pour avoir des informations sur la demande
                                    <a href="/Voir" class="text-decoration-none txt-bleufonce"> Voir</a>
                                </td>       
                                <td>
                                <input type="button" value="réalisé"/>   </td>           
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