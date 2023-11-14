package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.EmployessTerritoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoriesRepo extends JpaRepository<EmployessTerritoriesEntity, String> {
}
