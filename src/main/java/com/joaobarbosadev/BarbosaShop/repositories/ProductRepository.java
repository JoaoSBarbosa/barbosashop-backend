package com.joaobarbosadev.BarbosaShop.repositories;

import com.joaobarbosadev.BarbosaShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
