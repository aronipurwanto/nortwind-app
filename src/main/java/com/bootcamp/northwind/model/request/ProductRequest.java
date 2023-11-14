package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String id;
    private String name;
    /*private String supplierId;
    private String categoryId;*/
    private String quantity;
    private String price;
    private String inStock;
    private String onOrder;
    private String reOrder;
    private String discontinued;

    public ProductRequest(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
