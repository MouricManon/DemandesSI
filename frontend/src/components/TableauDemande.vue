<script setup>
import { reactive, onUpdated } from "vue";
import Demande from "@/Demande.js";
import CreationDemande from "@/components/CreationDemande.vue";

const data = reactive({
    id: "",
    demandes: [],
  
});
</script>
<template>
  <div>
 <div class="container bg-gradient-bleufonce rounded-3">

        <div class="container bg-marronclair rounded-3">
            <div class="container" v-if="data.id != ''">
                <div id="alerteMessage"></div>
                <div class="row">
                    <div class="col">
                            <label >Date de la demande</label>
                    </div>
                    <div class="col">
                            <label >Nom </label>
                    </div>
                    <div class="col">
                            <label  >Objet</label>
                    </div>
                       <div class="col">
                            <label  >Profession</label>
                    </div>
                </div>   <table>
                        <thead><tr>
                                <th class="info">Moyen de prise</th>
                                <th class="contreIndication">Contre Indication</th>
                                <th class="posologie">Posologie</th>
                                <th class="maladie">
                                    Maladie
                                    <i class="pointer arrow down"></i>
                                </th>
      
                            </tr>
                        </thead>
                        <tbody class="txt-violet">
                            <tr v-if="data.demandes.length != 0" v-for="demande in data.demandes">
                                <td class="avancement">
                                    <div class="progress">
                                        <div class="progress-bar bg-bleufonce" role="progressbar"
                                            :style="`width: ${soigner.avancement}%`"
                                            :aria-valuenow="`${soigner.avancement}`" aria-valuemin="0"
                                            aria-valuemax="100">
                                        </div>
                                    </div>
                                </td>
                                <td class="date">{{ soigner.datePriseAffichage }}</td>
                                <td class="debut d-none">{{ soigner.dateCreationAffichage }}</td>
                                <td class="fin">{{ soigner.dateFinAffichage }}</td>
                                <td>{{ soigner.nomMedicament }}</td>
                                <td class="info">{{ soigner.infoPrises }}</td>
                                <td class="contreIndication">{{ soigner.contreIndications }}</td>
                                <td class="posologie">{{ soigner.doseParPrise }} {{ soigner.dose }} {{
                                    soigner.valFreq
                                }}
                                    fois /
                                    {{
                                        soigner.uniteFreq
                                    }} pendant {{ soigner.valDuree }} {{ soigner.uniteDuree }}</td>
                                <td class="maladie">{{ soigner.nomMaladie }}</td>
                                <td>
                                    <ConfirmationSupprimer @supprConfirmed="deleteFetch" :id="soigner.id" />
                                </td>
                            </tr>
                            <tr v-else>
                                <td colspan="10">
                                    Vous n'avez aucun médicament dans votre liste. Vous pouvez en ajouter dans la page
                                    <a href="/ajoutTraitement" class="text-decoration-none txt-bleufonce">Ajout
                                        Traitement</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
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