package com.example.productservice.service;

import com.example.productservice.model.Product;

public interface ProductService {
    Product getProduct(String id);
    Product createProduct(Product product);
}
