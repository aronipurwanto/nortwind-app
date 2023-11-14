package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CustomerDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDemoRepo extends JpaRepository<CustomerDemoEntity,String> {
}
