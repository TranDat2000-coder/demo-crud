package com.example.demo_crud.service;

import com.example.demo_crud.request.ProductRequest;
import com.example.demo_crud.response.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getProductList();

    void insertProduct(ProductRequest request);

    void updateProduct(ProductRequest request);

    void deleteProduct(Long[] ids);
}
