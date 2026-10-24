package com.microservice.product;

import com.microservice.product.config.AppConfig;
import com.microservice.product.entity.Product;
import com.microservice.product.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * End-to-end scenario: save products through the service layer
 * and read them back from the database.
 */
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service through its interface (the bean is wrapped in a transactional proxy)
        ProductService productService = context.getBean(ProductService.class);

        productService.addProduct(new Product("Wireless Keyboard", 49.90));
        productService.addProduct(new Product("Ergonomic Mouse", 29.50));

        System.out.println("Products saved. Total in database: "
                + productService.getAllProducts().size());
        productService.getAllProducts().forEach(System.out::println);

        context.close();
    }
}
