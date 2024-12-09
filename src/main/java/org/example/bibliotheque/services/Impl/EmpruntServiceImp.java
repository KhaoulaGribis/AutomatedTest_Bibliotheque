package org.example.bibliotheque.services.Impl;

import org.example.bibliotheque.entities.Emprunt;
import org.example.bibliotheque.entities.Livre;
import org.example.bibliotheque.entities.Utilisateur;
import org.example.bibliotheque.repositories.EmpruntRepository;
import org.example.bibliotheque.services.EmpruntService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpruntServiceImp implements EmpruntService {
    private final EmpruntRepository empruntRepository;


    public EmpruntServiceImp(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;

    }

    @Override
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    @Override
    public Emprunt getEmprunt(Long id) {
        return empruntRepository.findById(id).orElse(null);
    }

    @Override
    public Emprunt createEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }
    @Override
    public Emprunt updateEmprunt(Long id, Emprunt emprunt) {
        Emprunt existingEmprunt = empruntRepository.findById(id).orElse(null);
        if (existingEmprunt != null) {
            existingEmprunt.setLivre(emprunt.getLivre());
            existingEmprunt.setUtilisateur(emprunt.getUtilisateur());
            existingEmprunt.setDateEmprunt(emprunt.getDateEmprunt());
            existingEmprunt.setDateRetour(emprunt.getDateRetour());
            return empruntRepository.save(existingEmprunt);
        }
        return null;
    }

    @Override
    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
    @Override
    public List<Emprunt> getEmpruntsByUtilisateur(Utilisateur utilisateur) {
        return empruntRepository.findByUtilisateur(utilisateur);
    }


}