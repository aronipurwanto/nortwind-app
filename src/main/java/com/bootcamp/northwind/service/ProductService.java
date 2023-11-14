package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.ProductRequest;
import com.bootcamp.northwind.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();
    Optional<ProductResponse> getById(String id);
    Optional<ProductResponse> save(ProductRequest request);
    Optional<ProductResponse> update(ProductRequest request, String id);
    Optional<ProductResponse> delete(String id);
}
