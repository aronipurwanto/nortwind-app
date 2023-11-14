package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.CustomerDemographisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDemographisRepo extends JpaRepository<CustomerDemographisEntity, String> {
}
