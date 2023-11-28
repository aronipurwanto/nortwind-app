package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.CategoryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id")
    private ProductsEntity products;

    public CategoryEntity(CategoryRequest request) {
        BeanUtils.copyProperties(request, this);
    }
}
