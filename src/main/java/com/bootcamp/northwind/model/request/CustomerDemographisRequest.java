package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDemographisRequest {
    private String customerTypeId;
    private String desc;
}
