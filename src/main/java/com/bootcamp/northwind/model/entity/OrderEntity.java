package com.bootcamp.northwind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_order")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private String id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "order")
    private LocalDate order;
    @Column(name = "required_date")
    private LocalDate required;
    @Column(name = "shipped_date")
    private LocalDate shipped;
    @Column(name = "shipp_via")
    private String shipVia;
    @Column(name = "freight")
    private String freight;
    @Column(name = "shipp_name")
    private String shipName;
    @Column(name = "shipp_address")
    private String shipAddress;
    @Column(name = "shipp_city")
    private String shipCity;
    @Column(name = "shipp_region")
    private String shipRegion;
    @Column(name = "shipp_postal_code")
    private String shipPostalCode;
    @Column(name = "shipp_country")
    private String shipCountry;
}
