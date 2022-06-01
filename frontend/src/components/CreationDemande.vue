<script setup>
import { onMounted, reactive, ref } from "vue";

import { format } from "path";

const listDemande= reactive([]);
const listeSearch = reactive([]);
const patients = reactive([]);
const demandes = reactive([]);

onMounted(() => {
  lesDemandes("");
  getDemandes();
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
}



function lesDemandes(demande) {
  let fetchOptions = { method: "GET" };
  fetch("/api/medicamentsByName?mot=" + demande)
    .then((response) => {
      return response.json();
    })

    .then((dataJSON) => {
      listeSearch.splice(0, listeSearch.length);
      dataJSON.forEach((v) => listeSearch.push(v));
    })

    .catch((error) => { });
}





function listDemandeEvent(
  nom, prenom, adressemail, objet, caractere, profession, pb, lien
) {
  listDemande.push(
    new demande(
     nom, prenom, adressemail, objet, caractere, profession, pb, lien
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
      item._lien,
      item._date
    );
  });
  listDemande.splice(0, listDemande.length);
}

function postDemande(
   nom, prenom, adressemail, objet, caractere, profession, pb, lien,
  date
) {
  let url = "/api/saveDemande";
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({
         nom :nom , prenom: prenom, adressemail:adressemail, objet:objet, caractere:caractere, profession:profession, pb:pb,lien: lien,
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
         nom, prenom, adressemail, objet, caractere, profession, pb, lien
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
<input id="pjDemande" v-model="lien"/>
        </div>
          <input id="valider" type="submit" value="Ajouter" @click="putDemande()"/>
      </form>
      </div>
      

   
</template>