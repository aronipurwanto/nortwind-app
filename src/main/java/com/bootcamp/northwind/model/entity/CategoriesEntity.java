package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.CategoriesRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_categories")
public class CategoriesEntity {
    @Id
    @Column(name = "category_id")
    private String id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String description;

//    @OneToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<ProductEntity> product = new ArrayList<>();


    public CategoriesEntity(CategoriesRequest request) {
        BeanUtils.copyProperties(request, this);
        this.id = UUID.randomUUID().toString();
    }

//    public void addCategories(ProductEntity productEntity){
//        this.product.add(productEntity);
//        productEntity.setCategories(this);
//    }
}
