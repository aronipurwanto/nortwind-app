package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {
}
