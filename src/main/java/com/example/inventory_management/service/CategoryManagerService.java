package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManagerService implements CategoryManager{

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return  categoryRepository.save(category);
    }


    @Override
    public boolean deleteCategory(Integer id) {
        try{
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Page<Category> getAllCategory(int page, int taille) {

        return categoryRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByCategoryName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> searchCategory(String keyword, int page, int taille ) {

        return categoryRepository.findCategoriesByCategoryDesignation(keyword, PageRequest.of(page,taille));
    }
}
