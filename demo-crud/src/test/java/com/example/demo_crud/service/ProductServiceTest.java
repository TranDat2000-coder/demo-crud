package com.example.demo_crud.service;

import com.example.demo_crud.common.ErrorCode;
import com.example.demo_crud.entity.Product;
import com.example.demo_crud.repository.ProductRepository;
import com.example.demo_crud.request.ProductRequest;
import com.example.demo_crud.response.ProductResponse;
import com.example.demo_crud.response.common.BusinessException;
import com.example.demo_crud.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    ProductRequest productRequest;
    Product product;

    Product product1;
    Product product2;

    @BeforeEach
    void setUp() {
        //Dữ liệu đầu vào
        productRequest = new ProductRequest();
        productRequest.setNameProduct("Product Samsung");
        productRequest.setPrice(BigDecimal.valueOf(900));
        productRequest.setQuantity(1);

        product = new Product();
        product.setNameProduct("Product Samsung");
        product.setPrice(BigDecimal.valueOf(900));
        product.setQuantity(1);

        //Dữ liệu giả lập
        product1 = new Product();
        product1.setId(1L);
        product1.setNameProduct("Product Samsung");
        product1.setPrice(BigDecimal.valueOf(900));
        product1.setQuantity(1);

        product2 = new Product();
        product2.setId(2L);
        product2.setNameProduct("Product Iphone");
        product2.setPrice(BigDecimal.valueOf(500));
        product2.setQuantity(3);
    }


    @Test
    void testGetAllProduct(){

        List<Product> products = Arrays.asList(product1, product2);

        //Tạo ra một giả lập cho hành vi của phương thức getAll
        when(productRepository.findAll()).thenReturn(products);

        //Gọi phương thức cần test
        List<ProductResponse> productsRe = productService.getProductList();

        assertEquals(2, productsRe.size());
        assertEquals("Product Samsung", products.get(0).getNameProduct());
        assertEquals("Product Iphone", products.get(1).getNameProduct());

        //Xác minh repository được gọi đúng
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetAllProduct_ThrowException(){
        //Arrange
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);

        //Act
        BusinessException exception = assertThrows(BusinessException.class, () -> productService.getProductList());

        //Assert
        assertEquals(ErrorCode.DATA_EMPTY.getErrorCode(), exception.getErrorCode());
        assertEquals(ErrorCode.DATA_EMPTY.getMessage(), exception.getMessage());

        verify(productRepository, times(1)).findAll();
    }


    @Test
    void testCreateProduct() {

        when(productRepository.save(product)).thenReturn(product1);

        Product productSave = productService.insertProduct(productRequest);

        assertEquals(productSave.getId(), product1.getId());
        assertEquals(productSave.getNameProduct(), product1.getNameProduct());
    }

//    @Test
//    void findByIdTest() {
//        when(productRepository.save(product))
//                .thenReturn(Product.builder()
//                        .id(1L)
//                        .nameProduct("Product 1")
//                        .price(BigDecimal.valueOf(900))
//                        .quantity(2)
//                        .build());
//
//        ProductRequest productRequest = ProductRequest.builder()
//                .nameProduct(product.getNameProduct())
//                .price(product.getPrice())
//                .quantity(product.getQuantity())
//                .build();
//
//        Product productSave = productService.insertProduct(productRequest);
//
//        Exception exception = assertThrows(ObjectNotFoundException.class, () -> productRepository.findById(2L));
//        String expectedMessage = "Object not found";
//        String actualMessage = exception.getMessage();
//
//        assertEquals(expectedMessage, actualMessage);
//    }
}
