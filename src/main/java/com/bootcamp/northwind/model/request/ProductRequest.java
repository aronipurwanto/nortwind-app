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
    private String productName;
    private String supplierId;
    private String supplierName;

    private String categoryId;
    private Integer qtyUnit;
    private Double unitPrice;
    private Integer unitStock;
    private Integer unitsOrder;
    private Integer reorderLevel;
    private Integer discontinued;
//    private List<CategoriesRequest> category = new ArrayList<>();

    public ProductRequest(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getSupplier() != null){
            this.supplierId = entity.getSupplier().getId();
            this.supplierName = entity.getSupplier().getCompanyName();
        }
    }
}
