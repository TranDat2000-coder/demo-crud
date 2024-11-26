package com.example.demo_crud;

import com.example.demo_crud.entity.Product;
import com.example.demo_crud.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void findTestAll(){
        Product product1 = Product.builder()
                .nameProduct("Product 1")
                .price(BigDecimal.valueOf(900))
                .quantity(20)
                .build();
        Product product2 = Product.builder()
                .nameProduct("Product 2")
                .price(BigDecimal.valueOf(700))
                .quantity(10)
                .build();
        Product product3 = Product.builder()
                .nameProduct("Product 3")
                .price(BigDecimal.valueOf(200))
                .quantity(22)
                .build();
        List<Product> products = Arrays.asList(product1, product2, product3);
        productRepository.saveAll(products);
        List<Product> allProduct = productRepository.findAll();
        assertEquals(3, allProduct.size());
    }

    @Test
    void findTestById(){
        Product product = Product.builder()
                .nameProduct("Product 1")
                .price(BigDecimal.valueOf(900))
                .quantity(20)
                .build();
        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findOneById(1L);
        assertTrue(productOptional.isPresent());
    }
}
