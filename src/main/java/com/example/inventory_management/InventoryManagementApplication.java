package com.example.inventory_management;

import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.entities.Product;
import com.example.inventory_management.service.CategoryManager;
import com.example.inventory_management.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

    @Autowired
    public ProductManager productManager;
    @Autowired
    public CategoryManager categoryManager;
    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null,"Tech","Pc Protable", null);
        categoryManager.addCategory(category);
        Product product = new Product(null,"HP", "Pc Portable" ,150, 100, "11234", category);
        productManager.addProduct(product);

        Category category1 = new Category(null,"Cuisine","Aliment", null);
        categoryManager.addCategory(category1);
        Product product1 = new Product(null,"Apple", "Pc Portable" ,55, 100, "11231", category);
        productManager.addProduct(product1);
    }
}
