package com.example.productservice_1.configurations;

import com.example.productservice_1.services.FakeStoreProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationConfiguration {
    // Spring will call this method
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
