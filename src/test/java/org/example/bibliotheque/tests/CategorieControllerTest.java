package org.example.bibliotheque.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bibliotheque.controllers.CategorieController;
import org.example.bibliotheque.entities.Categorie;
import org.example.bibliotheque.services.CategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategorieControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategorieService categorieService;

    @InjectMocks
    private CategorieController categorieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categorieController).build();
    }

    @Test
    void testCreateCategorie() throws Exception {
        Categorie categorie = new Categorie(1L, "Fiction", null);
        when(categorieService.createCategorie(any(Categorie.class))).thenReturn(categorie);

        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(categorie)))
                .andExpect(status().isCreated());

        verify(categorieService, times(1)).createCategorie(any(Categorie.class));
    }

    @Test
    void testUpdateCategorie() throws Exception {
        Categorie categorie = new Categorie(1L, "Romans", null);
        when(categorieService.updateCategorie(anyLong(), any(Categorie.class))).thenReturn(categorie);

        mockMvc.perform(put("/api/categories/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(categorie)))
                .andExpect(status().isOk());

        verify(categorieService, times(1)).updateCategorie(anyLong(), any(Categorie.class));
    }

    @Test
    void testGetAllCategories() throws Exception {
        List<Categorie> categories = Arrays.asList(
                new Categorie(1L, "Fiction", null),
                new Categorie(2L, "Non-fiction", null)
        );
        when(categorieService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk());

        verify(categorieService, times(1)).getAllCategories();
    }

    @Test
    void testGetCategorieById() throws Exception {
        Categorie categorie = new Categorie(1L, "Fiction", null);
        when(categorieService.getCategorie(anyLong())).thenReturn(categorie);

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isOk());

        verify(categorieService, times(1)).getCategorie(anyLong());
    }

//    @Testaaaaaapppp
//    void testDeleteCategorie() throws Exception {
//        long categorieId = 1L;
//        doNothing().when(categorieService).deleteCategorie(categorieId);
//        mockMvc.perform(delete("/categorie/{id}", categorieId));
//
//        verify(categorieService, times(1)).deleteCategorie(categorieId);
//    }
//}
}
