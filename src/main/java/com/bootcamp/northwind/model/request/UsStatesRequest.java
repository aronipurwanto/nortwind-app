package com.bootcamp.northwind.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsStatesRequest {
    private String id;
    private String name;
    private String abbr;
    private String region;
}
