package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoriesEntity, Long> {
}
