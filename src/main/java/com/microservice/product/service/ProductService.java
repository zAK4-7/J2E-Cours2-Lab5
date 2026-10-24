package com.microservice.product.service;

import com.microservice.product.entity.Product;

import java.util.List;

/**
 * Business-layer contract for products.
 */
public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
}
