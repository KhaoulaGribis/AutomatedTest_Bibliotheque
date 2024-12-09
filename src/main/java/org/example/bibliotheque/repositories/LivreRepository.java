package org.example.bibliotheque.repositories;

import org.example.bibliotheque.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository< Livre, Long> {

    List<Livre> findByDisponibleTrue();
    List<Livre> findByDisponibleFalse();
}
