package com.bootcamp.northwind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer_demographis")
public class CustomerDemographisEntity {
    @Id
    @Column(name = "customer_type_id")
    private String customerTypeId;
    @Column(name = "description")
    private String desc;
}
