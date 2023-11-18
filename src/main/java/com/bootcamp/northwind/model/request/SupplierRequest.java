package com.bootcamp.northwind.model.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequest {
    private String id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Double address;
    private Double city;
    private Double region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;
}
