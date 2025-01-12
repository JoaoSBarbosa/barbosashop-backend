package com.joaobarbosadev.BarbosaShop.controllers;

import com.joaobarbosadev.BarbosaShop.dto.ProductDTO;
import com.joaobarbosadev.BarbosaShop.entities.Product;
import com.joaobarbosadev.BarbosaShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(Pageable pageable) {
        Page<ProductDTO> page = productService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
