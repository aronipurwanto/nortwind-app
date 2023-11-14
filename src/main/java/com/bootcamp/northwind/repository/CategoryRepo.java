package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {
}
