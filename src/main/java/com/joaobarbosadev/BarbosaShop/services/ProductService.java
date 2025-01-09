package com.joaobarbosadev.BarbosaShop.services;

import com.joaobarbosadev.BarbosaShop.controllers.ProductController;
import com.joaobarbosadev.BarbosaShop.entities.Product;
import com.joaobarbosadev.BarbosaShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
