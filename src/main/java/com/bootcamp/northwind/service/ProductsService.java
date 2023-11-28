package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.ProductsRequest;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductsRequest> getAll();
    Optional<ProductsRequest> getById(Long id);
    Optional<ProductsRequest> save(ProductsRequest request);
    Optional<ProductsRequest> update (ProductsRequest request, Long id );
    Optional<ProductsRequest> delete (Long id);
}
