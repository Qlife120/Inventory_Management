package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Page<Category> findByCategoryDesignationContains(String keyword, Pageable pageable);
    Category findCategoryByCategoryName(String categoryName);

}
