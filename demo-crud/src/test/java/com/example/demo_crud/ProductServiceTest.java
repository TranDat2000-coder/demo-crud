package com.example.demo_crud;

import com.example.demo_crud.entity.Product;
import com.example.demo_crud.repository.ProductRepository;
import com.example.demo_crud.service.IProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private IProductService productService;

    static Product product;
    static Product product2;
    static Product product3;

    @BeforeAll
    static void setUp() {
        product = Product.builder()
                .nameProduct("Product 1")
                .price(BigDecimal.valueOf(900))
                .quantity(20)
                .build();
        product2 = Product.builder()
                .nameProduct("Product 2")
                .price(BigDecimal.valueOf(700))
                .quantity(10)
                .build();
        product3 = Product.builder()
                .nameProduct("Product 3")
                .price(BigDecimal.valueOf(200))
                .quantity(22)
                .build();
    }

    @Test
    void saveTest() {
        when(productRepository.save(product)).thenReturn(Product.builder()
                .id(1l)
                .nameProduct("Product 1")
                .price(BigDecimal.valueOf(900))
                .quantity(20)
                .build());

        Product prod = productService.insertProduct(product);
    }
}
