<script setup>
import { onMounted, reactive, ref } from "vue";
import traitement from "@/Traitement.js";
import TabRecapMedic11 from "@/components/TabRecapMedic11.vue";
import { format } from "path";
const listeunitFreq = reactive([]);
const listeunitDuree = reactive([]);
const listDemande= reactive([]);
const listeSearch = reactive([]);
const patients = reactive([]);
const maladies = reactive([]);

onMounted(() => {
  getFrequence();
  getDuree();
  lesMedicaments("");
  getPatients();
  getMaladies();
});

function getPatients(event) {
  let url = "/api/ListePatient/";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => response.json())
    .then((json) => {
      json.forEach((v) => patients.push(v));
    })
    .catch((error) => alert(error));
}

function getMaladies(event) {
  let url = "/api/maladies";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => response.json())
    .then((json) => {
      let results = json._embedded.maladies;
      results.forEach((v) => maladies.push(v));
    })
    .catch((error) => alert(error));
}



function lesMedicaments(medic) {
  let fetchOptions = { method: "GET" };
  fetch("/api/medicamentsByName?mot=" + medic)
    .then((response) => {
      return response.json();
    })

    .then((dataJSON) => {
      listeSearch.splice(0, listeSearch.length);
      dataJSON.forEach((v) => listeSearch.push(v));
    })

    .catch((error) => { });
}



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
}

function listDemandeEvent(
  nom, prenom, adressemail, objet, caractere, profession, pb, piecejointe
) {
  listDemande.push(
    new demande(
     nom, prenom, adressemail, objet, caractere, profession, pb, piecejointe
    )
  );
  document.getElementById("form").reset();
}


function putDemande() {
  listTraitement.forEach((item, index) => {
    postDemande(
      item._nom,
      item._prenom,
      item._adressemail,
      item._objet,
      item._caractere,
      item._profession,
      item._pb,
      item._piecejointe,
      item._date
    );
  });
  listDemande.splice(0, listDemande.length);
}

function postDemande(
   nom, prenom, adressemail, objet, caractere, profession, pb, piecejointe,
  date
) {
  let url = "/api/saveDemande";
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({
         nom :nom , prenom: prenom, adressemail:adressemail, objet:objet, caractere:caractere, profession:profession, pb:pb,piecejointe: piecejointe,
      datecreation: date,
    
    }),
  };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => { });
}
</script>

<template>
  
    
    <div class="formulaireTraitement">
      <form @submit.prevent="
        listDemandeEvent(
         nom, prenom, adressemail, objet, caractere, profession, pb, piecejointe
        )
      " id="form" class="row g-3">
      <div  class="col-md-6">
        <h4 id="identite">Indiquez votre nom et prénom:</h4>
        <input id="nomDemande" v-model="nom" placeholder="Nom"/>
        <input id="prenomDemande" v-model="prenom"  placeholder="Prénom"/>
        </div>        
        <div  class="col-md-6">
          <h4 id="objet">Indiquez la nature de votre demande</h4>
<input id="objetDemande" v-model="objet"  placeholder="Objet"/>
        </div>
         <div  class="col-md-6">
           <h4 id="priorite">Indiquez le niveau d'urgence</h4>
           <select class="select"  v-model="caractere"> 
          <option v-for="(caractere,index) of caracteres">
            {{ caractere}}
          </option>
        </select></div>
        <div  class="col-md-6">
           <select class="select" id="selectrech" v-model="profession">  <option disabled selected>
            Choissisez votre profession dans la liste
          </option>
          <option v-for="(profession,index) of professions">
            {{ profession}}
          </option>
        </select></div>
        <div  class="col-md-6">
          <h4 id="objet">Décrivez votre problème</h4>
<input id="pbDemande" v-model="pb"/>
        </div>
        <div  class="col-md-6">
          <h4 id="pj">Ajoutez une image si besoin</h4>
<input id="pjDemande" v-model="piecejointe"/>
        </div>
          <input id="valider" type="submit" value="Ajouter" />
      </form>
      </div>
      

   
</template>