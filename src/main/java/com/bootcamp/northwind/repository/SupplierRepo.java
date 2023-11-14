package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {
}
