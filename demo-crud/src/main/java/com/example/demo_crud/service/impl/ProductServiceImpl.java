package com.example.demo_crud.service.impl;

import com.example.demo_crud.common.ErrorCode;
import com.example.demo_crud.entity.Product;
import com.example.demo_crud.repository.ProductRepository;
import com.example.demo_crud.request.ProductRequest;
import com.example.demo_crud.response.ProductResponse;
import com.example.demo_crud.response.common.BusinessException;
import com.example.demo_crud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductList() {
        List<ProductResponse> productResponses = new ArrayList<>();

        List<Product> products = productRepository.findAll();
        if (CollectionUtils.isEmpty(products)) {
            throw new BusinessException(ErrorCode.DATA_EMPTY);
        }

        productResponses = products.stream()
                .map(product -> new ProductResponse().builder()
                        .id(product.getId())
                        .nameProduct(product.getNameProduct())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());


        return productResponses;
    }

    @Override
    public Product insertProduct(ProductRequest request) {
//        Product products = productRepository.findByName(request.getNameProduct());

        Product product = Product.builder()
                .nameProduct(request.getNameProduct())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        return productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequest request) {

        Optional<Product> products = productRepository.findOneById(request.getId());
        if (Objects.isNull(products)) {
            return;
        }

        Product product = products.get();

        product = Product.builder()
                .id(request.getId())
                .nameProduct(request.getNameProduct())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long[] ids) {
        for (Long id : ids) {
            if (!productRepository.existsById(id)) {
                return;
            }
            productRepository.deleteById(id);
        }
    }
}
