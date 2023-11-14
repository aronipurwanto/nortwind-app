package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity, String> {
}
