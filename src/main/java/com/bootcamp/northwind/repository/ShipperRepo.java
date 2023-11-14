package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepo extends JpaRepository<ShipperEntity, String> {
}
