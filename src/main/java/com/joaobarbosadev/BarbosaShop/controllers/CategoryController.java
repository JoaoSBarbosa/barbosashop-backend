package com.joaobarbosadev.BarbosaShop.controllers;
import com.joaobarbosadev.BarbosaShop.dto.CategoryDTO;
import com.joaobarbosadev.BarbosaShop.entities.Category;
import com.joaobarbosadev.BarbosaShop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {


    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {
        Page<CategoryDTO> categories = categoryService.findAll(pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO dto = categoryService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category){
        category = categoryService.insert(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
