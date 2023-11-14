package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
