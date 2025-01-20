package com.hiroshi.spring_api.services;

import com.hiroshi.spring_api.dtos.CreateProductDTO;
import com.hiroshi.spring_api.dtos.ProductDTO;
import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.entities.SupplierEntity;
import com.hiroshi.spring_api.exceptions.ConflictException;
import com.hiroshi.spring_api.exceptions.NotFoundException;
import com.hiroshi.spring_api.repositories.ProductRepository;
import com.hiroshi.spring_api.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(UUID id) {
        return productRepository.findById(id)
                .map(ProductDTO::new)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    @Transactional
    public ProductDTO createProduct(CreateProductDTO dto) {
        SupplierEntity supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));

        boolean productAlreadyExists = productRepository.findByName(dto.getName()).orElse(null) != null;
        if(productAlreadyExists) {
            throw new ConflictException("Produto com o mesmo nome ja cadastrado");
        }
        ProductEntity product = new ProductEntity();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSupplier(supplier);

        return new ProductDTO(productRepository.save(product));
    }

    @Transactional
    public ProductDTO updateProduct(UUID id, CreateProductDTO dto) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        return new ProductDTO(productRepository.save(product));
    }

    @Transactional
    public void deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }

}
