package com.bootcamp.northwind.model.response;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String id;
    private String name;
    private String desc;
    List<ProductResponse> product = new ArrayList<>();

    public CategoryResponse(CategoryEntity category) {
        BeanUtils.copyProperties(category, this);

    }
}
