package fr.jfc.demande.dto;

import java.util.Date;

import fr.jfc.demande.enume.Categorie;
import fr.jfc.demande.enume.Profession;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Un "DTO" (Data Transfer Object) pour représenter 
 * un soigner.
 */
@Data
@Getter @Setter // Lombok pour auto-générer getter / setter / toString...
public class DemandeForm {
    private Date datecreation;
    private String nomdemandeur;
    private String prenomdemandeur;
    private String adressemail;
    private String objet;
    private Categorie categorie;
    private Profession profession;
    private String pb;
  private String lien;
    private boolean traitement_realise;
}
