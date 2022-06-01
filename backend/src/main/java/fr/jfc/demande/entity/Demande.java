package fr.jfc.demande.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import fr.jfc.demande.enume.Categorie;
import fr.jfc.demande.enume.Profession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @NoArgsConstructor @ToString
@Entity 
public class Demande {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    @NonNull
    private String nom_demandeur;
    private String prenom_demandeur;
    private String adressemail;
    private String objet;
    @Enumerated(EnumType.ORDINAL)
    private Categorie categorie;
    @Enumerated(EnumType.ORDINAL)
    private Profession profession;
    @NonNull
    private String pb;
private String lien;
@Column(columnDefinition = "boolean default false")
    private boolean traite;

    @ManyToOne
    private Administrateur administrateur;


}
