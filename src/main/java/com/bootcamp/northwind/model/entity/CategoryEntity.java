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
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "cateogry_id")
    private String id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "description")
    private String desc;
    @Column(name = "picture")
    private String picture;

}
