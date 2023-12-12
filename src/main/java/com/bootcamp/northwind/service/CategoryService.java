package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.CategoriesRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoriesRequest> getAll();
    Optional<CategoriesRequest> getById(Long id);
    Optional<CategoriesRequest> save(CategoriesRequest request);
    Optional<CategoriesRequest> update(CategoriesRequest request, Long id);
    Optional<CategoriesRequest> delete(Long id);
}
