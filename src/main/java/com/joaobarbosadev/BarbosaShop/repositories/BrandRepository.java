package com.joaobarbosadev.BarbosaShop.repositories;

import com.joaobarbosadev.BarbosaShop.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
