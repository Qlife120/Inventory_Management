package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Category;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CategoryManager {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public boolean deleteCategory(Integer id);
    public Page<Category> getAllCategory(int page, int taille );
    public Category getCategoryById(Integer id);
    public Category getCategoryByName(String categoryName);
    public List<Category> getAllCategories();
    public Page<Category> searchCategory(String keyword, int page, int taille);

}
