package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierModel> getAll();
    SupplierModel getById(String id);
    Optional<SupplierModel> save(SupplierModel request);
    Optional<SupplierModel> update(SupplierModel request, String id);
    Optional<SupplierModel> delete(String id);
}
