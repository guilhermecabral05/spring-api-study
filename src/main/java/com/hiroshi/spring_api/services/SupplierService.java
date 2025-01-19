package com.hiroshi.spring_api.services;

import org.springframework.stereotype.Service;
import com.hiroshi.spring_api.dtos.CreateSupplierDTO;
import com.hiroshi.spring_api.entities.SupplierEntity;
import com.hiroshi.spring_api.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierEntity createSupplier(CreateSupplierDTO supplierDTO) {
        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(supplierDTO.getName());
        return supplierRepository.save(supplier);
    }

    public Optional<SupplierEntity> getSupplierById(String id) {
        return supplierRepository.findById(id);
    }

    public Iterable<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public SupplierEntity updateSupplier(SupplierEntity supplierEntity) {
        return supplierRepository.save(supplierEntity);
    }

    public void deleteSupplier(String id) {
        supplierRepository.deleteById(id);
    }
}

