package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductRequest> getAll();
    ProductRequest getById(String id);
    Optional<ProductRequest> save(ProductRequest request);
    Optional<ProductRequest> update(ProductRequest request, String id);
    Optional<ProductRequest> delete(String id);
}
