export default
    class Demande {
    constructor(nom, prenom, adressemail, objet, caractere, profession, pb, piecejointe,traite) {
        this._nom = nom;
        this._prenom = prenom;
        this._adressemail = adressemail;
        this._objet = objet;
        this._caractere = caractere;
        this._profession = profession;
        this._pb = pb;
        this._piecejointe = piecejointe;
        this._traite = traite;
        this._date = new Date();
    }

}