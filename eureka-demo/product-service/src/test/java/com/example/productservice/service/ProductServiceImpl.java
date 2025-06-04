package com.example.productservice.service;

import com.example.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProduct(String id) {
        return new Product("Produkt_" + id, 42.0);
    }

    @Override
    public Product createProduct(Product product) {
        // z.B. in DB speichern (hier simuliert)
        return product;
    }
}
