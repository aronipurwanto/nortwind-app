package com.bootcamp.northwind.service.serviceImpl;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import com.bootcamp.northwind.model.request.CategoryRequest;
import com.bootcamp.northwind.repository.CategoryRepo;
import com.bootcamp.northwind.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public List<CategoryRequest> getAll() {
        return this.categoryRepo.findAll().stream().map(CategoryRequest::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryRequest> getById(String id) {
        CategoryEntity result = this.categoryRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new CategoryRequest(result));
    }

    @Override
    public Optional<CategoryRequest> save(CategoryRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CategoryEntity result = new CategoryEntity(request);

        try {
            this.categoryRepo.save(result);
            log.info("Save Category to database success");
            return Optional.of(new CategoryRequest(result));
        } catch (Exception e){
            log.error("Save Category to database failed, error :{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRequest> update(CategoryRequest request, String id) {
        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try {
            this.categoryRepo.save(entity);
            log.info("Update Category to database success");
            return Optional.of(new CategoryRequest(entity));
        } catch (Exception e ){
            log.error("Update Category to database failed, error:{}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRequest> delete(String id) {
        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Category With id :{}, not found", id);
            return Optional.empty();
        }

        try {
            this.categoryRepo.delete(entity);
            log.info("Delete From Database Category Success");
            return Optional.of(new CategoryRequest(entity));
        } catch (Exception e){
            log.error("Delete Category From Database Failed, error:{}",e.getMessage());
            return Optional.empty();
        }
    }
}
