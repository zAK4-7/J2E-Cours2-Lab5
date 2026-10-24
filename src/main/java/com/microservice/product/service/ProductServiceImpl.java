package com.microservice.product.service;

import com.microservice.product.dao.IDao;
import com.microservice.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Business logic for products. Each method runs inside a Spring-managed transaction.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IDao<Product> productDao;

    @Override
    @Transactional
    public void addProduct(Product product) {
        // Business rule: a price can never be negative
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        productDao.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}
