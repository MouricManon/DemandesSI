package fr.jfc.demande.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jfc.demande.entity.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
    // JPQL : formulée sur le modèle conceptuel de données
    @Query("SELECT adressemail FROM Administrateur")
    List<Administrateur> ListeSI();

}
