package com.joaobarbosadev.BarbosaShop.entities;
import com.joaobarbosadev.BarbosaShop.enums.Country;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_marca")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    @Enumerated(EnumType.STRING)
    private Country country;
    private String site;

    public Brand() {}

    public Brand(Long id, String name, String description, String logoUrl, Country country, String site) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.country = country;
        this.site = site;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Brand brand)) return false;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", country=" + country +
                ", site='" + site + '\'' +
                '}';
    }
}
