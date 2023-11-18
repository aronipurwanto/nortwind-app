package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.ProductsRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_products")
public class ProductsEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "unit_order")
    private Double unitOrder;

    @Column(name = "order_qty")
    private Double order;

    @Column(name = "re_order_qty")
    private String reOrder;

    @Column(name = "discount")
    private String discount;

    public ProductsEntity(ProductsRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }
}
