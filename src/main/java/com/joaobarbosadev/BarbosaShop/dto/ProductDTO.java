package com.joaobarbosadev.BarbosaShop.dto;

import com.joaobarbosadev.BarbosaShop.entities.Category;
import com.joaobarbosadev.BarbosaShop.entities.Product;

import javax.persistence.Column;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Instant date;

    private BrandDTO brand;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO() {}

    public ProductDTO(
            BrandDTO brand,
            Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
        this.brand = brand;
    }

    public ProductDTO( Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        date = product.getDate();
        if(product.getBrand() != null) {
            brand = new BrandDTO(product.getBrand());
        }
    }

    public ProductDTO(Product product, Set<Category> categories) {
        this(product);
        categories.forEach(category -> this.categories.add(new CategoryDTO(category)));
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }
}
