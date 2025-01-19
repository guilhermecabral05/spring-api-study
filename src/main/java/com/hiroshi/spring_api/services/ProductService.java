package com.hiroshi.spring_api.services;

import com.hiroshi.spring_api.dtos.CreateProductDTO;
import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.entities.SupplierEntity;
import com.hiroshi.spring_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    public ProductEntity createProduct(CreateProductDTO product) {

        SupplierEntity supplier = supplierService.getSupplierById(product   .getSupplierId()).orElse(null);

        ProductEntity createdProduct = new ProductEntity();
        createdProduct.setName(createdProduct.getName());
        createdProduct.setPrice(createdProduct.getPrice());
        createdProduct.setSupplier(supplier);
        return createdProduct;
    }

    public Iterable<ProductEntity> getProducts() {

        return productRepository.findAll();
    }

    public ProductEntity getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
