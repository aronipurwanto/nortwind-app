package com.bootcamp.northwind.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_employess")
public class EmployessEntity {
    @Id
    @Column(name = "employess_id" )
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "title")
    private String title;
    @Column(name = "title_courtesy")
    private String titleCourtesy;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "home_pages")
    private String homePage;
    @Column(name = "extension")
    private String extension;
    @Column(name = "photo")
    private String photo;
    @Column(name = "notes")
    private String notes;
    @Column(name = "report_to")
    private String reportTo;
    @Column(name = "photo_path")
    private String photoPath;
}
