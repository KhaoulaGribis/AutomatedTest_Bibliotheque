package org.example.bibliotheque.controllers;

import org.example.bibliotheque.entities.Categorie;
import org.example.bibliotheque.entities.Livre;
import org.example.bibliotheque.services.Impl.CategorieServiceImp;
import org.example.bibliotheque.services.Impl.LivreServiceImp;
import org.example.bibliotheque.services.LivreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public ResponseEntity<List<Livre>> getAllLivres() {
        List<Livre> livres = livreService.getAllLivres();
        return ResponseEntity.ok(livres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        Livre livre = livreService.getLivre(id);
        if (livre != null) {
            return ResponseEntity.ok(livre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) {
        Livre createdLivre = livreService.createLivre(livre);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLivre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        Livre updatedLivre = livreService.updateLivre(id, livre);
        if (updatedLivre != null) {
            return ResponseEntity.ok(updatedLivre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
        return ResponseEntity.noContent().build();
    }
}
