package com.example.productservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Macht die Klasse zu einem REST-Controller
@RequestMapping("/products") // Basis-URL für alle Endpunkte in dieser Klasse
public class ProductController {

    // In-Memory-Liste für Produkte (später durch Datenbank ersetzbar)
    private final List<Product> products = new ArrayList<>();

    @GetMapping // GET /products → Liste aller Produkte
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}") // GET /products/{id} → Produkt anhand Index zurückgeben
    public Product getProduct(@PathVariable int id) {
        if (id >= 0 && id < products.size()) {
            return products.get(id);
        } else {
            throw new IllegalArgumentException("Produkt mit ID " + id + " nicht gefunden.");
        }
    }

    @GetMapping("/fail") // GET /products/fail → absichtlicher Fehler zum Testen
    public String fail() {
        throw new RuntimeException("Absichtlicher Fehler zum Testen");
    }

    @PostMapping // POST /products → Neues Produkt erstellen
    public Product createProduct(@RequestBody Product product) {
        products.add(product);
        System.out.println("Neues Produkt: " + product.getName() + ", Preis: " + product.getPrice());
        return product;
    }
}
