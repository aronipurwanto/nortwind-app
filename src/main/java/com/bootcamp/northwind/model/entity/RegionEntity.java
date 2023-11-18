package com.bootcamp.northwind.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_region")
public class RegionEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "region_desc")
    private String regionDesc;
}
