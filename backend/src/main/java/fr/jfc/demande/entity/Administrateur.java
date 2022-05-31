package fr.jfc.demande.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


import lombok.Getter; //génère du code, librairie lombok
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor@RequiredArgsConstructor @ToString // code facilité
@Entity // déclare une entité JPA
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom; 
    @NonNull 
    private String adressemail;
    @NonNull
    private String prenom;

    @NonNull
    private String mdp;

  //  private image piecejointe;

    @OneToMany(mappedBy="administrateur")
    private Set<Demande> lesDemandes;
 
}
