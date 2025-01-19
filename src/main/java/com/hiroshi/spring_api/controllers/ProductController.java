package com.hiroshi.spring_api.controllers;

import com.hiroshi.spring_api.entities.ProductEntity;
import com.hiroshi.spring_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<ProductEntity>> getAllProducts() {
        Iterable<ProductEntity> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public String createNewProduct(@ResponseBody ProductEntity productEntity) {
        productService.createProduct()
        return "Hello World 12312312312 w";
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
