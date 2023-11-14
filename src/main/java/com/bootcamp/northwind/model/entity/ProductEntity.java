package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.ProductRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name")
    private String name;
    /*@Column(name = "supplier_id")
    private String supplierId;
    @Column(name = "category_id")
    private String categoryId;*/
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "unit_price")
    private String price;
    @Column(name = "units_in_stock")
    private String inStock;
    @Column(name = "units_on_order")
    private String onOrder;
    @Column(name = "reorder_level")
    private String reOrder;
    @Column(name = "discouned")
    private String discontinued;


    public ProductEntity(ProductRequest response) {
        BeanUtils.copyProperties(response, this);
    }
}
