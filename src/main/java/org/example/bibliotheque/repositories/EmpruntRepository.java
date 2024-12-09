package org.example.bibliotheque.repositories;

import org.example.bibliotheque.entities.Emprunt;
import org.example.bibliotheque.entities.Livre;
import org.example.bibliotheque.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {

    List<Emprunt> findByLivre(Livre livre);
    List<Emprunt> findByUtilisateur(Utilisateur utilisateur);

}
