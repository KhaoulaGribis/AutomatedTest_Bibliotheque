package org.example.bibliotheque.services.Impl;

import org.example.bibliotheque.entities.Categorie;
import org.example.bibliotheque.entities.Livre;
import org.example.bibliotheque.repositories.LivreRepository;
import org.example.bibliotheque.services.Impl.CategorieServiceImp;
import org.example.bibliotheque.services.LivreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImp implements LivreService {
    private final LivreRepository livreRepository;


    public LivreServiceImp(LivreRepository livreRepository, CategorieServiceImp categorieService) {
        this.livreRepository = livreRepository;

    }

    @Override
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public Livre getLivre(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Override
    public Livre createLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre updateLivre(Long id, Livre livre) {
        Livre existingLivre = livreRepository.findById(id).orElse(null);
        if (existingLivre != null) {
            existingLivre.setTitre(livre.getTitre());
            existingLivre.setAuteur(livre.getAuteur());
            existingLivre.setDisponible(livre.isDisponible());
            return livreRepository.save(existingLivre);
        }
        return null;
    }

    @Override
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}

