package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDemoRequest {
    private String id;
    private String customerTypeId;
}
