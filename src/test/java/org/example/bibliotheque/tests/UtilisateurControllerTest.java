package org.example.bibliotheque.tests;

import org.example.bibliotheque.controllers.UtilisateurController;
import org.example.bibliotheque.entities.Utilisateur;
import org.example.bibliotheque.services.UtilisateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class UtilisateurControllerTest {
    @InjectMocks
    private UtilisateurController utilisateurController;

    @Mock
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUtilisateurs() {
        when(utilisateurService.getAllUtilisateurs()).thenReturn(Collections.emptyList());
        var utilisateurs = utilisateurController.getAllUtilisateurs();
        assertNotNull(utilisateurs);
        verify(utilisateurService, times(1)).getAllUtilisateurs();
    }

    @Test
    void testGetUtilisateurById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        when(utilisateurService.getUtilisateur(1L)).thenReturn(utilisateur);

        var result = utilisateurController.getUtilisateur(1L);
        assertNotNull(result);
        verify(utilisateurService, times(1)).getUtilisateur(1L);
    }

    @Test
    void testCreateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        when(utilisateurService.createUtilisateur(any(Utilisateur.class))).thenReturn(utilisateur);

        var result = utilisateurController.createUtilisateur(utilisateur);
        assertNotNull(result);
        verify(utilisateurService, times(1)).createUtilisateur(any(Utilisateur.class));
    }

    @Test
    void testUpdateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        when(utilisateurService.updateUtilisateur(eq(1L), any(Utilisateur.class))).thenReturn(utilisateur);

        var result = utilisateurController.updateUtilisateur(1L, utilisateur);
        assertNotNull(result);
        verify(utilisateurService, times(1)).updateUtilisateur(eq(1L), any(Utilisateur.class));
    }

    @Test
    void testDeleteUtilisateur() {
        doNothing().when(utilisateurService).deleteUtilisateur(1L);
        utilisateurController.deleteUtilisateur(1L);
        verify(utilisateurService, times(1)).deleteUtilisateur(1L);
    }
}
