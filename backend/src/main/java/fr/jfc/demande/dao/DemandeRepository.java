package fr.jfc.demande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.jfc.demande.entity.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {

}
