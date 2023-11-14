package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesRequest {
    private String id;
    private String lastName;
    private String firstName;
    private String title;
    private String titleCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePage;
    private String extension;
    private String photo;
    private String notes;
    private String reportTo;
    private String photoPath;
}
