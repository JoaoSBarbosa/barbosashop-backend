package com.joaobarbosadev.BarbosaShop.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "Text")
    private String description;
    private Double price;
    private String imgUrl;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_produto_categoria",
            joinColumns = @JoinColumn(
                    name = "id_produto",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            value = ConstraintMode.CONSTRAINT,
                            name = "fk_produto_categoria"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_categoria",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            value = ConstraintMode.CONSTRAINT,
                            name = "fk_categoria_produto"
                    )
            )
    )
    private Set<Category> categories = new HashSet<>();



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;


    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public Product(Long id, String name, String description, Double price, String imgUrl, Instant date, Set<Category> categories, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
        this.categories = categories;
        this.brand = brand;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
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

    public String getImgUri() {
        return imgUrl;
    }

    public void setImgUri(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                ", date=" + date +
                ", categories=" + categories +
                ", brand=" + brand +
                '}';
    }
}
