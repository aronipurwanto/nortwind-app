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
@Table(name = "tbl_us_states")
public class UsStatesEntity {
    @Id
    @Column(name = "state_id")
    private String id;
    @Column(name = "state_name")
    private String name;
    @Column(name = "state_abbr")
    private String abbr;
    @Column(name = "state_region")
    private String region;
}
