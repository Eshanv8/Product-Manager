package com.example.Product_Manager.repository;
import com.example.Product_Manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryIgnoreCase(String category);

    Optional<Product> findByProductNameIgnoreCase(String productName);

    @Transactional
    void deleteByProductNameIgnoreCase(String productName);
}