package org.example.bibliotheque.services;

import org.example.bibliotheque.entities.Livre;

import java.util.List;

public interface LivreService {
    List<Livre> getAllLivres();
    Livre getLivre(Long id);
    Livre createLivre(Livre livre);
    Livre updateLivre(Long id, Livre livre);
    void deleteLivre(Long id);
}
