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
    private Double quantityPerUnit;
    private Double unitPrice;
    private Double stock;
    private String onOrder;
    private Double reorderLevel;
    private String discontinued;
    private String categoryId;
    private CategoryResponse category;
    private String supplierId;
    private SupplierResponse supplier;

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getCategory() != null){
            this.id = entity.getCategoryId();
            this.category = new CategoryResponse(entity.getCategory());
        }

        if (entity.getSupplier() != null){
            this.id = entity.getSupplierId();
            this.supplier = new SupplierResponse(entity.getSupplier());
        }


    }
}
