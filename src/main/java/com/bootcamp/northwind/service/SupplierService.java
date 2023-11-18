package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.SupplierRequest;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierRequest> getAll();
    Optional<SupplierRequest> getById(String id);
    Optional<SupplierRequest> save(SupplierRequest request);
    Optional<SupplierRequest> update (SupplierRequest request, String id );
    Optional<SupplierRequest> delete (String id);
}
