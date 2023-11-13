package com.bootcamp.northwind.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryResponse {
    private String id;
    private String name;
    private String desc;
    private String picture;

}
