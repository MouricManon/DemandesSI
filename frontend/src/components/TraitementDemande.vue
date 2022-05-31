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
              Nom du médicament : <br />
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
  </div></template>*/-->   <!-- Bouton -->