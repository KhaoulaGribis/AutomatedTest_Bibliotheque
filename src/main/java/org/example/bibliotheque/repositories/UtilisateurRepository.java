package org.example.bibliotheque.repositories;

import org.example.bibliotheque.entities.Livre;
import org.example.bibliotheque.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository
        extends JpaRepository<Utilisateur, Long> {
     }
