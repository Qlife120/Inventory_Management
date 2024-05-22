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
public class ProductController {

    @Autowired
    public ProductManager productManager;

    @Autowired
    private CategoryManager categoryManager;

    @GetMapping("")
    public String start(){
        return "redirect:dashboard";
    }

    @GetMapping("/dashboard")
    public String displayDashboard(Model model){
        List<Product> products = productManager.getAllProuctsList();
        long  StockValue = 0;
        for (int i=0;i<products.size();++i){
            Product currentProduct = products.get(i);
            StockValue += (currentProduct.getQuantity() * currentProduct.getPrice());
        }
        int totalProducts = products.size();
        int  totalCategories = categoryManager.getAllCategories().size();
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalCategories", totalCategories);
        model.addAttribute("StockValue", StockValue);
        return "dashboard";

    }
    @GetMapping("/indexpage")
    public String ProductsList(Model model){
        List<Product> products = productManager.getAllProuctsList();
        model.addAttribute("products",products);
        return "indexlayout";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(Model model){
        Product product = new Product();
        List<Category> categories = categoryManager.getAllCategories();
        model.addAttribute("newProduct", product);
        model.addAttribute("categories", categories);
        return "ProductForm";
    }

    //Using @ModelAttribute
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("newProduct") Product product ) {
        productManager.addProduct(product);
        return "redirect:/indexpage";
    }


    @GetMapping("/UpdateProduct")
    public String updateProduct(Model model,@RequestParam(name = "id") Integer id ){
        Product product = productManager.getProductById(id);
        List<Category> categories = categoryManager.getAllCategories();
        model.addAttribute("productToBeUpdated",product);
        model.addAttribute("categories", categories);
        return "Update_Product";
    }

    // Using RequestParam
    @PostMapping("/UpdateProductPost")
    public String updateProductPost(@RequestParam(name="id") Integer id,
                                     @RequestParam(name="productName") String productName,
                                    @RequestParam(name="designation") String desigantion,
                                    @RequestParam(name="quantity") int quantity,
                                    @RequestParam(name="price") double price,
                                    @RequestParam(name="barcode") String barcode,
                                    @RequestParam(name="categoryName") String categoryName){


        Category category = categoryManager.getCategoryByName(categoryName);
        Product product = new Product(id, productName,desigantion,price,quantity,barcode,category);
        productManager.updateProduct(product);
        return "redirect:indexpage";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(name="id") Integer id){
        if(productManager.deleteProduct(id)){
            return "redirect:indexpage";
        }
        return "redirect:indexpage";
    }



}
