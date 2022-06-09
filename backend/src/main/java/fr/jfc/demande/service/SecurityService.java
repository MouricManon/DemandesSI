package fr.jfc.demande.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}