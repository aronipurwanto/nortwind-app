package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {
    private String id;
    private String productName;
    private String supplierId;
    private String categoryId;
    private Double quantity;
    private Double price;
    private Double stock;
    private Double unitOrder;
    private Double order;
    private String reorder;
    private String discount;
}
