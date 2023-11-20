package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private String productName;

    @Column(name = "supplier_id")
    private String supplierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @Column(name = "category_id")
    private String categoryId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "category_id")
//    private CategoriesEntity categories;

    @Column(name = "qty_unit")
    private Integer qtyUnit;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "unit_stock")
    private Integer unitStock;

    @Column(name = "units_order")
    private Integer unitsOrder;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "discontinued")
    private Integer discontinued;

    public ProductEntity(ProductRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }

}
