package com.joaobarbosadev.BarbosaShop.dto;
import com.joaobarbosadev.BarbosaShop.entities.Brand;
import com.joaobarbosadev.BarbosaShop.enums.Country;

public class BrandDTO {

    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private Country country;
    private String site;

    public BrandDTO() {}

    public BrandDTO(Long id, String name, String description, String logoUrl, Country country, String site) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.country = country;
        this.site = site;
    }

    public BrandDTO(Brand brand) {
        id = brand.getId();
        name = brand.getName();
        description = brand.getDescription();
        logoUrl = brand.getLogoUrl();
        country = brand.getCountry();
        site = brand.getSite();

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
