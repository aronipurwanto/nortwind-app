package com.bootcamp.northwind.sImpl;

import com.bootcamp.northwind.model.entity.CategoriesEntity;
import com.bootcamp.northwind.model.request.CategoriesRequest;
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
    public List<CategoriesRequest> getAll() {
        return this.categoryRepo.findAll()
                .stream()
                .map(CategoriesRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriesRequest getById(String id) {
        return this.categoryRepo.findById(id)
                .map(CategoriesRequest::new)
                .orElse(null);
    }

    @Override
    public Optional<CategoriesRequest> save(CategoriesRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CategoriesEntity entity = new CategoriesEntity(request);
        try {
            this.categoryRepo.save(entity);
            log.info("Save category to database success");
            return Optional.of(new CategoriesRequest(entity));
        }catch (Exception e){
            log.error("Save category to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoriesRequest> update(CategoriesRequest request, String id) {
        CategoriesEntity entity = this.categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            this.categoryRepo.save(entity);
            log.info("Update category to database success");
            return Optional.of(new CategoriesRequest(entity));
        }catch (Exception e){
            log.error("Update category to database failed, error: {} ", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoriesRequest> delete(String id) {
        CategoriesEntity result = this.categoryRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("Category with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.categoryRepo.delete(result);
            log.info("Delete Category from database success");
            return Optional.of(new CategoriesRequest(result));
        }catch (Exception e){
            log.error("Delete category from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
