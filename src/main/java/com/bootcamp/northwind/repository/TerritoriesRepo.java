package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.TerritoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoriesRepo extends JpaRepository<TerritoriesEntity, String> {
}
