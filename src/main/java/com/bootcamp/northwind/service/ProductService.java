package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();
    ProductResponse getById(String id);
    Optional<ProductResponse> save(ProductResponse response);
    Optional<ProductResponse> update(ProductResponse response, String id);
    Optional<ProductResponse> delete(String id);
}
