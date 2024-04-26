package com.example.productservice_1.services;

import com.example.productservice_1.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(Long id);
    public Product createProduct(String title, String description,
                                 String image, String category, double price);

    public List<Product> getAllProducts();
}
