package org.example.bibliotheque.services;

import org.example.bibliotheque.entities.Emprunt;
import org.example.bibliotheque.entities.Utilisateur;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> getAllEmprunts();
    Emprunt getEmprunt(Long id);

    Emprunt createEmprunt(Emprunt emprunt);
    Emprunt updateEmprunt(Long id, Emprunt emprunt);
    void deleteEmprunt(Long id);
    List<Emprunt> getEmpruntsByUtilisateur(Utilisateur utilisateur);
}


