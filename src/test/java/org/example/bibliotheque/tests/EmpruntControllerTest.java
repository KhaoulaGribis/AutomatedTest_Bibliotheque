package org.example.bibliotheque.tests;

import org.example.bibliotheque.controllers.EmpruntController;
import org.example.bibliotheque.entities.Emprunt;
import org.example.bibliotheque.services.EmpruntService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmpruntControllerTest {
    @InjectMocks
    private EmpruntController empruntController;

    @Mock
    private EmpruntService empruntService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmprunts() {
        when(empruntService.getAllEmprunts()).thenReturn(Collections.emptyList());
        var emprunts = empruntController.getAllEmprunts();
        assertNotNull(emprunts);
        verify(empruntService, times(1)).getAllEmprunts();
    }

    @Test
    void testGetEmpruntById() {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(1L);
        when(empruntService.getEmprunt(1L)).thenReturn(emprunt);

        var result = empruntController.getEmprunt(1L);
        assertNotNull(result);
        verify(empruntService, times(1)).getEmprunt(1L);
    }

    @Test
    void testCreateEmprunt() {
        Emprunt emprunt = new Emprunt();
        emprunt.setId(1L);
        when(empruntService.createEmprunt(any(Emprunt.class))).thenReturn(emprunt);

        var result = empruntController.createEmprunt(emprunt);
        assertNotNull(result);
        verify(empruntService, times(1)).createEmprunt(any(Emprunt.class));
    }

    @Test
    void testDeleteEmprunt() {
        doNothing().when(empruntService).deleteEmprunt(1L);
        empruntController.deleteEmprunt(1L);
        verify(empruntService, times(1)).deleteEmprunt(1L);
    }


}
