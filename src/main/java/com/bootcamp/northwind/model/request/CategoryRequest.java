package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String id;
    private String categoryName;
    private String description;
    private List<ProductsRequest> products = new ArrayList<>();

    public CategoryRequest(CategoryEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
