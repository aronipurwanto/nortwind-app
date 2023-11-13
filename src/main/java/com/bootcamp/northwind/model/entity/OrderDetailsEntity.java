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
@Table(name = "tbl_order_details")
public class OrderDetailsEntity {
    @Id
    @Column(name = "order_id")
    private String id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "unit_price")
    private String price;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "discount")
    private String discount;
}
