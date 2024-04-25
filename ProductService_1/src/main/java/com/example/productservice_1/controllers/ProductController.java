package com.example.productservice_1.controllers;

import com.example.productservice_1.dtos.CreateProductRequestDto;
import com.example.productservice_1.models.Product;
import com.example.productservice_1.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    //Dependency injection Spring will create service class object and pass here
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto) {
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImage(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    public void deleteProduct(Long id) {

    }
}
