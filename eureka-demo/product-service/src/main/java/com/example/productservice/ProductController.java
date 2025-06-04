package com.example.productservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Produkt mit ID " + id + " nicht gefunden."));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
}