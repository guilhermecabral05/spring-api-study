package com.hiroshi.spring_api.controllers;

import com.hiroshi.spring_api.dtos.CreateProductDTO;
import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Map<String,Iterable<ProductEntity>>> getAllProducts() {
        Iterable<ProductEntity> products = productService.getProducts();
        return ResponseEntity.ok(Map.of("products", products));
    }

    @PostMapping
    @Validated
    public ResponseEntity<ProductEntity> createNewProduct(@Valid @RequestBody CreateProductDTO product) {
        ProductEntity createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("{id}")
    public String updateProduct() {
        return "Hello World 12312312312 w";
    }

    @DeleteMapping("{id}")
    public String deleteProduct() {
        return "Hello World 12312312312 w";
    }


}
