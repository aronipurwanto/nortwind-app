package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CustomerDemographicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDemographicsRepo extends JpaRepository<CustomerDemographicsEntity, String> {
}
