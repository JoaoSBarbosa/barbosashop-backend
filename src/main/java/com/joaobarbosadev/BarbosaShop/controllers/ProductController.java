package com.joaobarbosadev.BarbosaShop.controllers;

import com.joaobarbosadev.BarbosaShop.dto.ProductDTO;
import com.joaobarbosadev.BarbosaShop.entities.Product;
import com.joaobarbosadev.BarbosaShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        productDTO = productService.save(productDTO);
        return ResponseEntity.ok(productDTO);
    }
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable) {
        Page<ProductDTO> page = productService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
