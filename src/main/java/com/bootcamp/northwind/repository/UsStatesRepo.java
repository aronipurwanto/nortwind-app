package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.UsStatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsStatesRepo extends JpaRepository<UsStatesEntity, String> {
}
