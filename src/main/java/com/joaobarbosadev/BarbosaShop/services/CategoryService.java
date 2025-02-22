package com.joaobarbosadev.BarbosaShop.services;

import com.joaobarbosadev.BarbosaShop.Exceptions.ControllerNotFoundException;
import com.joaobarbosadev.BarbosaShop.Exceptions.DataBaseException;
import com.joaobarbosadev.BarbosaShop.Utils.Utils;
import com.joaobarbosadev.BarbosaShop.components.CustomResponse;
import com.joaobarbosadev.BarbosaShop.dto.CategoryDTO;
import com.joaobarbosadev.BarbosaShop.entities.Category;
import com.joaobarbosadev.BarbosaShop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    HttpServletRequest servletRequest;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map((CategoryDTO::new));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Categoria não encontrada com o ID: " + id));
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO category) {
        Category entity = new Category();
        entity.setName(category.getName());
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CustomResponse<CategoryDTO> insertCustom(CategoryDTO category) {

        Category entity = new Category();
        entity.setName(category.getName());

        entity = categoryRepository.save(entity);
        CustomResponse<CategoryDTO> response = new CustomResponse<>();
        response.setData(new CategoryDTO(entity));
        response.setMessage("Categoria inserida com sucesso!");
        response.setPath(servletRequest.getRequestURI());
        response.setStatus(HttpStatus.CREATED.value());
        response.setTimestamp(Utils.getFormatterInstance());
        return response;
    }


    @Transactional
    public CategoryDTO update(CategoryDTO dto, Long id) {
        try {
            Category category = categoryRepository.getReferenceById(id);
            if (dto.getName() != null) category.setName(dto.getName());
            category = categoryRepository.save(category);
            return new CategoryDTO(category);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Não foi localizado registro de categoria com o ID: " + id);
        }
    }

    public String delete(Long id) {
        try {
            categoryRepository.deleteById(id);
            return "Categoria removida com sucesso.";

        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException("Nenhum registro de categoria encontrado com o ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade. O registro está vinculado a outros dados e não pode ser removido.");
        }
    }



}
