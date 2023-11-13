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
@Table(name = "tbl_employess_territories")
public class EmployessTerritoriesEntity {
    @Id
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "territory_id")
    private String territoryId;
}
