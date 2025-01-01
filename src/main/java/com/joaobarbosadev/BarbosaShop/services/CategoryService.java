package com.joaobarbosadev.BarbosaShop.services;

import com.joaobarbosadev.BarbosaShop.Exceptions.ControllerNotFoundException;
import com.joaobarbosadev.BarbosaShop.dto.CategoryDTO;
import com.joaobarbosadev.BarbosaShop.entities.Category;
import com.joaobarbosadev.BarbosaShop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map((CategoryDTO::new));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Categoria não encontrada com o ID: " + id));
        return new CategoryDTO(category);
    }

    @Transactional
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }


}
