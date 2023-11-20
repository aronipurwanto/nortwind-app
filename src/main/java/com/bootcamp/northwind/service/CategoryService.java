package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.CategoriesRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoriesRequest> getAll();
    CategoriesRequest getById(String id);
    Optional<CategoriesRequest> save(CategoriesRequest request);
    Optional<CategoriesRequest> update(CategoriesRequest request, String id);
    Optional<CategoriesRequest> delete(String id);
}
