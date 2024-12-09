package org.example.bibliotheque.services.Impl;

import org.example.bibliotheque.entities.Categorie;
import org.example.bibliotheque.repositories.CategorieRepository;
import org.example.bibliotheque.services.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImp(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }
    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Long id, Categorie categorie) {
        Categorie existingCategorie = categorieRepository.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setNom(categorie.getNom());
            return categorieRepository.save(existingCategorie);
        }
        return null;
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}


