package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManager {
    public Product addProduct(Product product);
    public Product getProductById(Integer id);
    public Page<Product> getAllProducts(int page, int taille);
    public Page<Product> searchProducts(String keyword, int page , int taille);
    public Product updateProduct(Product product);
    public boolean deleteProduct(Integer id);
    public List<Product> getAllProuctsList();
    public List<Product> getProductsByCategoryId(Integer id);

}
