package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDemoResponse{

    private String id;
    private String customerTypeId;
    private String customerId;
}
