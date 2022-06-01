<script setup>
import { onMounted, reactive, ref } from "vue";
import Demande from "@/Demande.js";
import { format } from "path";


const listDemande= reactive([]);
const listeSearch = reactive([]);
const demandes = reactive([]);
const categories = reactive([]);
const professions = reactive([]);
let item = reactive();

onMounted(() => {
  lesDemandes("");
  getDemandes();
  getProfession();
  getCategories();
  postDemande();
  putDemande();
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


 function getCategories(event) {
  let url = "/api/allCategories";
  let fetchOptions = { method: "Get" };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      dataJSON.forEach((v) => categories.push(v));
    })
    .catch((error) => { });
}

function getProfession(event) {
  let url = "/api/allProfessions";
  let fetchOptions = { method: "GET" };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      dataJSON.forEach((v) => professions.push(v));
    })
    .catch((error) => { });
}


function listDemandeEvent(
  nom, prenom, adressemail, objet, categorie, profession, pb, lien
) {
  listDemande.push(
 new Demande(
     nom, prenom, adressemail, objet, categorie, profession, pb, lien
    )
  );
  document.getElementById("form").reset();
}


function putDemande() {
  listDemande.forEach((item, index) => {
    postDemande(
      item._nom,
      item._prenom,
      item._adressemail,
      item._objet,
      item._categorie,
      item._profession,
      item._pb,
      item._lien,
      item._date
    );
  });
  listDemande.splice(0, listDemande.length);
  console.log(item);
}

function postDemande(
   nom, prenom, adressemail, objet, categorie, profession, pb, lien,
  date
) {
  let url = "/api/saveDemande";
  let myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  const fetchOptions = {
    method: "POST",
    headers: myHeaders,
    body: JSON.stringify({
         nom :nom , prenom: prenom, adressemail:adressemail, objet:objet, categorie:categorie, profession:profession, pb:pb,lien: lien,
      datecreation: date,
    
    }),
  };
  fetch(url, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => { 
      document.getElementById("texte").innerHTML =
        "Votre demande concernant : "+objet+" a bien été ajouté à la base de données";});
}
</script>

<template>
    <div class="formulaireTraitement">
      <form @submit.prevent="
        listDemandeEvent(
         nom, prenom, adressemail, objet, categorie, profession, pb, lien
        )
      " id="form" class="row g-3">
      <div class="col-md-6">
        <label for="nom,prenom">Indiquez votre nom et prénom :</label>
        <input class="input" type="text" id="nomDemande" v-model="nom" placeholder="Nom"/>
        <input class="input" type="text" id="prenomDemande" v-model="prenom"  placeholder="Prénom"/>
        </div>        
        <div  class="col-md-6">
          <label for="objet">Indiquez la nature de votre demande :</label>
          <input class="input" id="objetDemande"   cols="60" maxlength="60" type="text" v-model="objet"  placeholder="Objet"/>
        </div>
         <div  class="col-md-6">
            <label for="categorie">Indiquez le niveau d'urgence :</label>
           <select class="select"  v-model="categorie" >
           <option value="" selected disabled>--Niveau d'urgence--</option> 
          <option v-for="(categorie,index) of categories">
            {{ categorie}}
          </option>
        </select></div>
        <div  class="col-md-6">
          <label for="profession">Sélectionnez votre profession :</label>
           <select class="select" id="selectrech" v-model="profession" > 
            <option value="placehold" selected disabled>--Votre profession--</option> 
          <option v-for="(profession,index) of professions">
            {{ profession}}
          </option>
        </select></div>
        <div  class="col-md-6">
          <label for="pb">Décrivez votre problème :</label>
        <textarea  rows="10" cols="100" maxlength="1000" class="input"  id="pbDemande"  placeholder="Nous sommes à votre écoute" v-model="pb"/>
        </div>
        <div  class="col-md-6">
          <label for="image">Ajoutez une image si besoin :</label>
           <input v-model="lien" cols="60" maxlength="60" type="text" placeholder="lien"/>
        <input id="parcourir" type="submit" value="parcourir" />
        </div>
        <div class="col-md-6">
          <input id="valider"  type="submit" value="Envoyer" @click="putDemande()"/></div>
          <div class="col-md-6" id="texte"> </div>
      </form>
    </div>
</template>
<style>
#form{
  display:table;
 margin: 0 auto;
  width : 740px;
  text-align: center;
} 

#valider{
  cursor : pointer;
    color: black;
  border: 1px solid #000000;
  border-radius: 20px;
  background: white;
  width : 70px;
  position : relative;
  left : -211px;
}

h4{
  color : black;
}

.input{
  border-radius: 5px;
  background: white;
}

#pbDemande{
  width : 700px;
  height : 400px;
  text-align: justify;
}

.select{
  color:black;
}
</style>