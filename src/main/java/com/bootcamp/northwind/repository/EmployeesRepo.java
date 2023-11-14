package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.EmployessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<EmployessEntity, String> {
}
