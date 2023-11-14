package com.bootcamp.northwind.model.response;

import com.bootcamp.northwind.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
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

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
