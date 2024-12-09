package org.example.bibliotheque.repositories;

import org.example.bibliotheque.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
