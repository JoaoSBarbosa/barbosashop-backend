package com.joaobarbosadev.BarbosaShop.services;

import com.joaobarbosadev.BarbosaShop.Exceptions.ControllerNotFoundException;
import com.joaobarbosadev.BarbosaShop.controllers.ProductController;
import com.joaobarbosadev.BarbosaShop.dto.CategoryDTO;
import com.joaobarbosadev.BarbosaShop.dto.ProductDTO;
import com.joaobarbosadev.BarbosaShop.entities.Brand;
import com.joaobarbosadev.BarbosaShop.entities.Category;
import com.joaobarbosadev.BarbosaShop.entities.Product;
import com.joaobarbosadev.BarbosaShop.repositories.BrandRepository;
import com.joaobarbosadev.BarbosaShop.repositories.CategoryRepository;
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
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        Product entity = new Product();
        convertDtoToEntity(entity, productDTO);

        entity = productRepository.save(entity);
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map((product -> new ProductDTO(product, product.getCategories())));
    }

    private void convertDtoToEntity(Product product, ProductDTO productDTO) {
        if (productDTO.getId() != null) product.setId(productDTO.getId()); // O id deve vir do DTO
        if (productDTO.getName() != null) product.setName(productDTO.getName());
        if (productDTO.getDescription() != null) product.setDescription(productDTO.getDescription()); // Corrigido para 'setDescription'
        if (productDTO.getPrice() != null) product.setPrice(productDTO.getPrice()); // Corrigido para 'setPrice'
        if (productDTO.getImgUrl() != null) product.setImgUrl(productDTO.getImgUrl()); // Corrigido para 'setImgUrl'
        if (productDTO.getDate() != null) product.setDate(productDTO.getDate()); // Corrigido para 'setDate'

        if (productDTO.getBrand() != null) {
            Long brandId = productDTO.getBrand().getId();
            Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new ControllerNotFoundException("Não existe marca com o id informado: " + brandId));
            product.setBrand(brand); // Associe a marca
        }

        if (productDTO.getCategories() != null) {
            for (CategoryDTO categoryDTO : productDTO.getCategories()) {
                Long categoryId = categoryDTO.getId();
                Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new ControllerNotFoundException("Não existe categoria com o id informado: " + categoryId));
                product.getCategories().add(category);
            }
        }
    }

}
