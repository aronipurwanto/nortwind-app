package com.bootcamp.northwind.service.serviceImpl;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import com.bootcamp.northwind.model.entity.ProductsEntity;
import com.bootcamp.northwind.model.request.CategoryRequest;
import com.bootcamp.northwind.model.request.ProductsRequest;
import com.bootcamp.northwind.repository.ProductRepo;
import com.bootcamp.northwind.service.ProductsService;
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
public class ProductsServiceImpl implements ProductsService {

    private final ProductRepo productRepo;
    @Override
    public List<ProductsRequest> getAll() {
        return this.productRepo.findAll().stream().map(ProductsRequest::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductsRequest> getById(String id) {
        ProductsEntity result = this.productRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new ProductsRequest(result));
    }

    @Override
    public Optional<ProductsRequest> save(ProductsRequest request) {
        if (request == null){
            return Optional.empty();
        }

        ProductsEntity result = new ProductsEntity(request);

        try {
            this.productRepo.save(result);
            log.info("Save Products to database success");
            return Optional.of(new ProductsRequest(result));
        } catch (Exception e){
            log.error("Save Products to database failed, error :{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductsRequest> update(ProductsRequest request, String id) {
        ProductsEntity entity = this.productRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try {
            this.productRepo.save(entity);
            log.info("Update Products to database success");
            return Optional.of(new ProductsRequest(entity));
        } catch (Exception e ){
            log.error("Update Products to database failed, error:{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductsRequest> delete(String id) {
        ProductsEntity entity = this.productRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Products With id :{}, not found", id);
            return Optional.empty();
        }

        try {
            this.productRepo.delete(entity);
            log.info("Delete From Database Products Success");
            return Optional.of(new ProductsRequest(entity));
        } catch (Exception e){
            log.error("Delete From Database Products Failed, error:{}",e.getMessage());
            return Optional.empty();
        }
    }
}
