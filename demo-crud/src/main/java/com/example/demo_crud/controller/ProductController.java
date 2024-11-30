package com.example.demo_crud.controller;

import com.example.demo_crud.request.ProductRequest;
import com.example.demo_crud.response.ProductResponse;
import com.example.demo_crud.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://medium.com/@kouemosylvain/understand-and-implement-unit-testing-in-your-spring-boot-3-x-application-by-using-good-practices-83a2f8e8b7ca

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/get-product-list")
    public ResponseEntity<List<?>> getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }

    @PostMapping("/insert-product")
    public ResponseEntity<?> insertProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.insertProduct(productRequest);
        return ResponseEntity.ok("Insert product successfully");
    }

    @PostMapping("/update-product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest) {
        productService.updateProduct(productRequest);
        return ResponseEntity.ok("Update product successfully");
    }

    @DeleteMapping("/delete-product{id}")
    public ResponseEntity<?> deleteProduct(@RequestParam("id") Long[] ids) {
        productService.deleteProduct(ids);
        return ResponseEntity.ok("Delete product successfully");
    }
}
