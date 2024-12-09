package org.example.bibliotheque.tests;

import org.aspectj.lang.annotation.Before;
import org.example.bibliotheque.controllers.LivreController;
import org.example.bibliotheque.services.LivreService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.bibliotheque.entities.Livre;
import java.util.Collections;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class LivreControllerTest {

    @InjectMocks
    private LivreController livreController;

    @Mock
    private LivreService livreService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLivres() {
        when(livreService.getAllLivres()).thenReturn(Collections.emptyList());
        var livres = livreController.getAllLivres();
        assertNotNull(livres);
        verify(livreService, times(1)).getAllLivres();
    }

    @Test
    void testGetLivreById() {
        Livre livre = new Livre();
        livre.setId(1L);
        when(livreService.getLivre(1L)).thenReturn(livre);

        var result = livreController.getLivre(1L);
        assertNotNull(result);
        verify(livreService, times(1)).getLivre(1L);
    }
    @Test
    void testCreateLivre() {
        Livre livre = new Livre();
        livre.setId(1L);
        when(livreService.createLivre(any(Livre.class))).thenReturn(livre);

        var result = livreController.createLivre(livre);
        assertNotNull(result);
        verify(livreService, times(1)).createLivre(any(Livre.class));
    }

    @Test
    void testDeleteLivre() {
        doNothing().when(livreService).deleteLivre(1L);
        livreController.deleteLivre(1L);
        verify(livreService, times(1)).deleteLivre(1L);
    }
}
