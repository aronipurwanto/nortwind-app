package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.ProductsRequest;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductsRequest> getAll();
    Optional<ProductsRequest> getById(String id);
    Optional<ProductsRequest> save(ProductsRequest request);
    Optional<ProductsRequest> update (ProductsRequest request, String id );
    Optional<ProductsRequest> delete (String id);
}
