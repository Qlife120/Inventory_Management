package com.example.inventory_management.web;

import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.entities.Product;
import com.example.inventory_management.service.CategoryManager;
import com.example.inventory_management.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    public CategoryManager categoryManager;

    @Autowired
    public ProductManager productManager;

    @GetMapping("/indexCategory")
    public String CategoryList(Model model){
        List<Category> categories = categoryManager.getAllCategories();
            model.addAttribute("categories",categories);
        return "indexCategory";
    }

    @GetMapping("/addCategoryForm")
    public String addCategoryForm(Model model){
        Category category = new Category();
        model.addAttribute("newCategory", category);
        return "CategoryForm";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute(name = "newCategory") Category newCategory){
        categoryManager.addCategory(newCategory);
        return "redirect:indexCategory";
    }

    @GetMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable(name = "id") Integer id, Model model){
        Category category = categoryManager.getCategoryById(id);
        model.addAttribute("categoryToBeUpdated",category);
        return "Update_Category";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name="id") Integer id, Model model){
        List<Product> products = productManager.getProductsByCategoryId(id);
        if (!products.isEmpty()){
            String errorMessage = "Cannot delete category. There are still products related to this category.";
            model.addAttribute("errorMessage", errorMessage);
            return "errorCategory";
        }
        else{
            categoryManager.deleteCategory(id);
            return "redirect:indexCategory";
        }

    }


}
