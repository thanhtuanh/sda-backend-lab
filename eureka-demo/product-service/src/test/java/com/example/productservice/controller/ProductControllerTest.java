package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Field;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

public class ProductControllerTest {

    private MockMvc mockMvc;
    private ProductService productService;

    @BeforeEach
    public void setup() throws Exception {
        // 1. Mock für ProductService anlegen
        productService = Mockito.mock(ProductService.class);

        // 2. Controller instanziieren und das Mock per Reflection setzen
        ProductController controller = new ProductController();
        Field serviceField = ProductController.class.getDeclaredField("productService");
        serviceField.setAccessible(true);
        serviceField.set(controller, productService);

        // 3. MockMvc einrichten
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetProduct() throws Exception {
        // Mock-Verhalten definieren
        Product mockProduct = new Product("MockProdukt", 99.99);
        when(productService.getProduct("123")).thenReturn(mockProduct);

        // GET-Request ausführen und prüfen
        mockMvc.perform(get("/products/123"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("MockProdukt"))
               .andExpect(jsonPath("$.price").value(99.99));
    }

    @Test
    public void testCreateProduct() throws Exception {
        // Mock-Verhalten definieren
        Product newProduct = new Product("Neu", 12.34);
        when(productService.createProduct(Mockito.any())).thenReturn(newProduct);

        String json = """
                {
                  "name": "Neu",
                  "price": 12.34
                }
                """;

        // POST-Request ausführen und prüfen
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Neu"))
               .andExpect(jsonPath("$.price").value(12.34));
    }
}
