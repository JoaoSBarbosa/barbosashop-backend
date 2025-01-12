package com.joaobarbosadev.BarbosaShop.dto;

import com.joaobarbosadev.BarbosaShop.entities.Category;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Instant createdAt;


    public CategoryDTO() {}

    public CategoryDTO(Long id, String name, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
        createdAt = category.getCreatedAt();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
