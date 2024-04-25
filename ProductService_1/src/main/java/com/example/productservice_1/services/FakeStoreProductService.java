package com.example.productservice_1.services;

import com.example.productservice_1.dtos.FakeStoreProductDto;
import com.example.productservice_1.models.Category;
import com.example.productservice_1.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service // creates the object and put it into constructor of ProductController class
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate ;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate
                .getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
//        product.setPrice(fakeStoreProductDto.getPrice());
        return product;

    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setTitle(title);

        FakeStoreProductDto response = restTemplate
                .postForObject("https://fakestoreapi.com/products",
                        fakeStoreProductDto, FakeStoreProductDto.class);
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response =
                restTemplate.getForObject("https://fakestoreapi.com/products/",
        FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : response)
        {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }
}

