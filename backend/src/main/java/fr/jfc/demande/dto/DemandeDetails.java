package fr.jfc.demande.dto;


import java.util.Date;

import fr.jfc.demande.enume.Categorie;
import fr.jfc.demande.enume.Profession;
/**
 * Un "DTO" (Data Transfer Object) pour représenter 
 * le résultat d'une requête SQL.
 * Cette interface sera "automatiquement" implémentée par Spring.
 * @see monprojet.dao.DemandeRepository
 */
public interface DemandeDetails {
    int getId();
    String getNomdemandeur();
    String getPrenomdemandeur();
    String getAdressemail();
    String getObjet();
    Categorie getUniteDuree();
    Profession getProfession();
    String getpb();
  String getLien();
    Date getdateCreation();
    boolean getTraite();
}
