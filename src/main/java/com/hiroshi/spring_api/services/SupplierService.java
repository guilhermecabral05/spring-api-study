package com.hiroshi.spring_api.services;
import com.hiroshi.spring_api.dtos.CreateSupplierDTO;
import com.hiroshi.spring_api.dtos.SupplierDTO;
import com.hiroshi.spring_api.entities.SupplierEntity;
import com.hiroshi.spring_api.exceptions.NotFoundException;
import com.hiroshi.spring_api.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(SupplierDTO::new)
                .collect(Collectors.toList());
    }

    public SupplierDTO getSupplierById(UUID id) {
        return supplierRepository.findById(id)
                .map(SupplierDTO::new)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
    }

    @Transactional
    public SupplierDTO createSupplier(CreateSupplierDTO dto) {
        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(dto.getName());
        return new SupplierDTO(supplierRepository.save(supplier));
    }

    @Transactional
    public SupplierDTO updateSupplier(UUID id, CreateSupplierDTO dto) {
        SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));

        supplier.setName(dto.getName());
        return new SupplierDTO(supplierRepository.save(supplier));
    }

    @Transactional
    public void deleteSupplier(UUID id) {
        if (!supplierRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor não encontrado");
        }
        supplierRepository.deleteById(id);
    }
}
