package org.example.bibliotheque.controllers;

import org.example.bibliotheque.entities.Emprunt;
import org.example.bibliotheque.services.EmpruntService;
import org.example.bibliotheque.services.Impl.EmpruntServiceImp;
import org.example.bibliotheque.services.Impl.LivreServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {
    private final EmpruntService empruntService;

    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
    }

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        return ResponseEntity.ok(emprunts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmprunt(@PathVariable Long id) {
        Emprunt emprunt = empruntService.getEmprunt(id);
        if (emprunt != null) {
            return ResponseEntity.ok(emprunt);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping
    public ResponseEntity<Emprunt> createEmprunt(@RequestBody Emprunt emprunt) {
        Emprunt createdEmprunt = empruntService.createEmprunt(emprunt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmprunt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt emprunt) {
        Emprunt updatedEmprunt = empruntService.updateEmprunt(id, emprunt);
        if (updatedEmprunt != null) {
            return ResponseEntity.ok(updatedEmprunt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return ResponseEntity.noContent().build();
    }
}
