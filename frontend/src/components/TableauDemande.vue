<script setup>
import { onMounted, reactive, onUpdated } from "vue";
import Demande from "@/Demande.js";
import CreationDemande from "@/components/CreationDemande.vue";
import ConfirmationTraitement from './ConfirmationTraitement.vue';
onMounted(() => {
  getDemandes();
 affichageDate();
});
const data = reactive({
    id: "",
    demandes: [],
demandesSuppr:[],
});

function getDemandes() {
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

function affichageDate(){
 data.demandes.forEach((d) => 
 datesansmodif = d.getDate(),
datelocale= datesansmodif.toLocaleString('fr-FR',{
  weekday : 'long',
  year : 'numeric',
  month : 'long',
  day : 'numeric',
  hour:'numeric',
  minute : 'numeric',
  seconde : 'numeric'}
  d.setDate(datelocale)));

}
function deleteFetch(id) {
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    const fetchOptions = {
        method: "DELETE",
        headers: myHeaders,
    };
    fetch("/api/demandes/" + id, fetchOptions)
        .then(() => {
            fetchDemandes();
        })
        .catch((error) => alert(error));
}
function fetchDemandes() {
    fetch("/api/demandes/" + data.id)
        .then((response) => response.json())
        .then((json) => {
            data.demandes = json;
        })
        .catch((error) => alert(error));
}


</script>


<template>
 <div class="container">
   <p>Vous avez {{data.demandes.length}} demande(s) à traiter.</p>
   <table class="table">
      <thead><tr>
        <th class="date">Date</th>
        <th class="urgence">Urgence</th>
        <th class="nom">Nom</th>
        <th class="prenom">Prenom</th>
        <th class="objet">Objet</th>
        <th class="profession">Profession</th>
        <th class="demande">Voir</th>
        <th class="traite">Traité</th></tr>
      </thead>
      <tbody  class="txt-violet">
        <tr v-if="data.demandes.length != 0" v-for="demande in data.demandes">
        <td class="date">{{ demande.date }}</td>
        <td class="urgence">{{ demande.categorie }}</td>
        <td class="nom">{{ demande.nomdemandeur }}</td>
        <td class="prenom">{{ demande.prenomdemandeur }}</td>
        <td>{{ demande.objet }}</td>
        <td class="info">{{ demande.profession }}</td> 
        <td class="voir">
           <button value=demande.id class="btn-btn-primary" id="voir"  @click="$emit('laDemandeid', $event.target.value)"> Voir</button>
        </td>       
        <td>
        <ConfirmationTraitement @TraitementConfirmed="deleteFetch" :id="demande.id" /> </td>   </tr>
                            
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
#voir{
  color :rgb(46, 129, 197);
}
</style>
