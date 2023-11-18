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
@Table(name = "tbl_territories")
public class TerritoriesEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "territories_desc")
    private String territoryDesc;

    @Column(name = "region_id")
    private String regionId;
}
