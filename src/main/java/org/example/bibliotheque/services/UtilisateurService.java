package org.example.bibliotheque.services;

import org.example.bibliotheque.entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateur(Long id);
    Utilisateur createUtilisateur(Utilisateur utilisateur);
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);
    void deleteUtilisateur(Long id);

}
