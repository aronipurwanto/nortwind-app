package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<RegionEntity, String> {
}
