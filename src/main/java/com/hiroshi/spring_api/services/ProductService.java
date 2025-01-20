package com.hiroshi.spring_api.services;

import com.hiroshi.spring_api.dtos.CreateProductDTO;
import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.entities.SupplierEntity;
import com.hiroshi.spring_api.exceptions.NotFoundException;
import com.hiroshi.spring_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    public ProductEntity createProduct(CreateProductDTO product) {

        SupplierEntity supplier = supplierService.getSupplierById(product.getSupplierId()).orElse(null);

        if (supplier == null){
            throw new NotFoundException("Supplier not found");
        }

        ProductEntity createdProduct = new ProductEntity();
        createdProduct.setName(createdProduct.getName());
        createdProduct.setPrice(createdProduct.getPrice());
        createdProduct.setSupplier(supplier);
        return createdProduct;
    }

    public Iterable<ProductEntity> getProducts() {

        return productRepository.findAll();
    }

    public ProductEntity getProduct(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

}
