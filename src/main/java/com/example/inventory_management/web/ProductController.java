package com.example.inventory_management.web;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import com.example.inventory_management.dao.entities.Category;
import com.example.inventory_management.dao.entities.Product;
import com.example.inventory_management.dao.entities.Supplier;
import com.example.inventory_management.service.CategoryManager;
import com.example.inventory_management.service.ProductManager;
import com.example.inventory_management.service.SupplierManager;
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

    @Autowired
    private SupplierManager supplierManager;

 

    @GetMapping("")
    public String start(){
        return "redirect:login";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login" ;
    }

    @GetMapping("/dashboard")
    public String displayDashboard(Model model){
        List<Product> products = productManager.getAllProuctsList();
        long  StockValue = 0;
        
            // Fetch products with quantity less than 3
        List<Product> lowStockProducts = products.stream()
                                             .filter(product -> product.getQuantity() < 3)
                                             .limit(3)
                                             .collect(Collectors.toList());

        long lowStockCount = products.stream()
                                .filter(product -> product.getQuantity() < 3)
                                .count();                                  
        for (int i=0;i<products.size();++i){
            Product currentProduct = products.get(i);
            StockValue += (currentProduct.getQuantity() * currentProduct.getPrice());
        }

        List<Supplier> suppliers = supplierManager.getSuppliersList();
        int supplier_Number = suppliers.size();



        int totalProducts = products.size();
        int  totalCategories = categoryManager.getAllCategories().size();
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalCategories", totalCategories);
        model.addAttribute("StockValue", StockValue);
        model.addAttribute("lowStockProducts", lowStockProducts);
        model.addAttribute("lowStockCount", lowStockCount);
        model.addAttribute("supplier_Number", supplier_Number);
     

        return "dashboard";

    }
    /*@GetMapping("/indexpage")
    public String ProductsList(Model model){
        List<Product> products = productManager.getAllProuctsList();
        model.addAttribute("products",products);
        return "indexlayout";
    }*/

    @GetMapping("/indexpage")
    public String ProductsList(Model model, 
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "taille", defaultValue="6") int taille, 
                                @RequestParam(name = "search", defaultValue ="") String keyword)
                                {
            
            Page<Product> products = productManager.searchProducts(keyword,page, taille);   
            if(products.hasContent()){
                model.addAttribute("products", products.getContent());
            }
            else{
                System.out.println("-----------------------------------------------");
            }
            int[] pages = new int[products.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
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
    public String updateProductPost(@RequestParam(name="id") Integer     id,
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
        return "errorProduct";
    }



}
