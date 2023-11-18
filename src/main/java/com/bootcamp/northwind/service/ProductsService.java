package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryRequest> getAll();
    Optional<CategoryRequest> getById(String id);
    Optional<CategoryRequest> save(CategoryRequest request);
    Optional<CategoryRequest> update (CategoryRequest request, String id );
    Optional<CategoryRequest> delete (String id);
}
