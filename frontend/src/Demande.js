export default
    class Demande {
    constructor(nom, prenom, adressemail, objet, caractere, profession, pb, lien) {
        this._nom = nom;
        this._prenom = prenom;
        this._adressemail = adressemail;
        this._objet = objet;
        this._caractere = caractere;
        this._profession = profession;
        this._pb = pb;
        this._lien = lien;
        this._traite = false;
        this._date = new Date();
    }

}