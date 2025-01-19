package com.hiroshi.spring_api.services;

import com.hiroshi.spring_api.dtos.CreateProductDTO;
import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductEntity createProduct(CreateProductDTO productDTO) {
        ProductEntity product = new ProductEntity(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice()
        );
        productRepository.save(productDTO);
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
