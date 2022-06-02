export default
    class Demande {
    constructor(nomdemandeur, prenomdemandeur, adressemail, objet, categorie, profession, pb, lien) {
        this._nomdemandeur = nomdemandeur;
        this._prenomdemandeur = prenomdemandeur;
        this._adressemail = adressemail;
        this._objet = objet;
        this._categorie = categorie;
        this._profession = profession;
        this._pb = pb;
        this._lien = lien;
        this._traite = false;
        this._date = new Date();
        
    }

}