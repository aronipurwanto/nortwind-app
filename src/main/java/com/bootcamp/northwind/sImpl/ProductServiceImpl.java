package com.bootcamp.northwind.sImpl;

import com.bootcamp.northwind.model.entity.CategoriesEntity;
import com.bootcamp.northwind.model.entity.ProductEntity;
import com.bootcamp.northwind.model.request.CategoriesRequest;
import com.bootcamp.northwind.model.request.ProductRequest;
import com.bootcamp.northwind.repository.CategoryRepo;
import com.bootcamp.northwind.repository.ProductRepo;
import com.bootcamp.northwind.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public List<ProductRequest> getAll() {
        return this.productRepo.findAll()
                .stream()
                .map(ProductRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductRequest getById(String id) {
        return this.productRepo.findById(id)
                .map(ProductRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<ProductRequest> save(ProductRequest request) {
        if (request == null){
            return Optional.empty();
        }

        // create object
        ProductEntity entity = new ProductEntity(request);
        try {
            this.productRepo.save(entity);
            log.info("Save product to database success");
            return Optional.of(new ProductRequest(entity));
        }catch (Exception e){
            log.error("Save product to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRequest> update(ProductRequest request, String id) {
        ProductEntity entity = this.productRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            this.productRepo.save(entity);
            log.info("Update product to database success");
            return Optional.of(new ProductRequest(entity));
        }catch (Exception e){
            log.error("Update product to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductRequest> delete(String id) {
        ProductEntity result = this.productRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("Product with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.productRepo.delete(new ProductEntity());
            log.info("Delete product from database success");
            return Optional.of(new ProductRequest(result));
        }catch (Exception e){
            log.error("Delete product from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
