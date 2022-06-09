package fr.jfc.demande.service;

import fr.jfc.demande.entity.Utilisateur;

public interface UserService {
    void initializeRolesAndAdmin();

    void save(Utilisateur user);

    Utilisateur findByUserName(String username);
}