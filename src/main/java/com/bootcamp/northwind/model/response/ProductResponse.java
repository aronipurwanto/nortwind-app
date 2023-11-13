package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String supplierId;
    private String categoryId;
    private String quantity;
    private String price;
    private String inStock;
    private String onOrder;
    private String reOrder;
    private String discontinued;
}
