package com.joaobarbosadev.BarbosaShop.controllers;

import com.joaobarbosadev.BarbosaShop.dto.BrandDTO;
import com.joaobarbosadev.BarbosaShop.entities.Brand;
import com.joaobarbosadev.BarbosaShop.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    @Autowired
    BrandService brandService;


    @GetMapping
    public ResponseEntity<Page<BrandDTO>> getAllBrands(Pageable pageable) {
        Page<BrandDTO> brands = brandService.findAll(pageable);
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }
}
