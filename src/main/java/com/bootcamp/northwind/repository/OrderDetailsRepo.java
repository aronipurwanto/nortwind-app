package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetailsEntity, String> {
}
