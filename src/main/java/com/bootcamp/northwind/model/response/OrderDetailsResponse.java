package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponse {
    private String id;
    private String productId;
    private String price;
    private String quantity;
    private String discount;
}
