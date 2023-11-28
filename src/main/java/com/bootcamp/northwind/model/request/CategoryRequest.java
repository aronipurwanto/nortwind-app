package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private Long id;
    private String categoryName;
    private String description;

    public CategoryRequest(CategoryEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
