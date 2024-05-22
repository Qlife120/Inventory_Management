package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByDesignationContains(String keyword, Pageable pageable);
    List<Product> findAllByCategoryCategoryId(Integer id);

}
