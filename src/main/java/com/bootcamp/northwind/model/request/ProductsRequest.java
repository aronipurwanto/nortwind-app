package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {
    private String id;
    private String productName;
    private String supplierId;
    private String supplierName;
    private String category;
    private Double quantity;
    private Double price;
    private Double stock;
    private Double unitOrder;
    private Double order;
    private String reOrder;
    private String discount;

    public ProductsRequest(ProductsEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getSupplier() != null){
            this.supplierId = entity.getSupplier().getId();
            this.supplierName = entity.getSupplier().getCompanyName();
        }
    }
}
