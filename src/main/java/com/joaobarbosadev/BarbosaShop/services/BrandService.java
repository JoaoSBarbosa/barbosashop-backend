package com.joaobarbosadev.BarbosaShop.services;

import com.joaobarbosadev.BarbosaShop.dto.BrandDTO;
import com.joaobarbosadev.BarbosaShop.entities.Brand;
import com.joaobarbosadev.BarbosaShop.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Transactional(readOnly = true)
    public Page<BrandDTO> findAll(Pageable pageable) {
        Page<Brand> brands = brandRepository.findAll(pageable);
        return brands.map(BrandDTO::new);
    }
}
