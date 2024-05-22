package com.example.inventory_management.web;

import com.example.inventory_management.dao.entities.Stockroom;
import com.example.inventory_management.service.CategoryManager;
import com.example.inventory_management.service.StockroomManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StockroomContorller {

    @Autowired
    public StockroomManager stockroomManager;


    @GetMapping("/indexStockroom")
    public String Stoockroomlist(Model model){
        List<Stockroom> stockrooms = stockroomManager.getAllStockrooms();
        model.addAttribute("stockrooms",stockrooms);
        return "indexStockroom"; // Add Template;

    }

    @GetMapping("/addStockroomForm")
    public String addStockroomForm(Model model){
        Stockroom stockroom = new Stockroom();
        model.addAttribute(stockroom);
        return "StockroomForm";
    }

    @PostMapping("/addStockroom")
    public String addStockroom(@ModelAttribute(name = "newStockroom") Stockroom stockroom){
        stockroomManager.addStockroom(stockroom);
        return "redirect:indexStockroom";
    }

    @GetMapping("/updateStockroom/{id}")
    public String updateStockroom(@PathVariable(name = "id") Integer id, Model model){
        Stockroom stockroomToBeUpdated = stockroomManager.getStockroomById(id);
        model.addAttribute("stockroomToBeUpdated",stockroomToBeUpdated);
        return "Update_Stockroom";
    }

    @GetMapping("/deleteStockroom/")
    public String deleteStockroom(@RequestParam(name="id") Integer id){
        stockroomManager.deleteStockroom(id);
        return "redirect:indexStockroom";
    }




}
