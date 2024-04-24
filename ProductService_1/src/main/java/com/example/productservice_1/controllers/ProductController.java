package com.example.productservice_1.controllers;

import com.example.productservice_1.models.Product;
import com.example.productservice_1.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;
    //Dependency injection Spring will create service class object and pass here
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public void createProduct() {
        // Break for 5 minutes: 10:38 -> 10:43
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    public void deleteProduct(Long id) {

    }
}
