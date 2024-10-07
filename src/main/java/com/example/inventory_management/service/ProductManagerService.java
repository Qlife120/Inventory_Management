package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Product;
import com.example.inventory_management.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductManagerService implements ProductManager{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Product not found for id number: " + id);
        }
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page,taille));
    }

    // method that handles the search when keyword = "" then all products are displayed.
    @Override
    public Page<Product> searchProducts(String keyword, int page, int taille) {
        return productRepository.findByDesignationContains(keyword, PageRequest.of(page,taille));
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Integer id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public List<Product> getAllProuctsList() {
        return productRepository.findAll();
    }
    public List<Product> getProductsByCategoryId(Integer id){
        return  productRepository.findAllByCategoryCategoryId(id);
    }

}
