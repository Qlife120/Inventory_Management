package com.example.inventory_management.web;

import org.springframework.data.domain.Page;
import com.example.inventory_management.dao.entities.Stockroom;
import com.example.inventory_management.service.StockroomManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
    
import java.util.List;

@Controller
public class StockroomContorller {

    @Autowired
    public StockroomManager stockroomManager;


    /*@GetMapping("/indexStockroom")
    public String Stoockroomlist(Model model){
        List<Stockroom> stockrooms = stockroomManager.getAllStockrooms();
        model.addAttribute("stockrooms",stockrooms);
        return "indexStockroom"; 

    }*/

    @GetMapping("/indexStockroom")
    public String Stockroomlist(Model model,
                                @RequestParam(name="page", defaultValue="0") int page,
                                @RequestParam(name = "taille", defaultValue = "6") int taille,
                                @RequestParam(name="search", defaultValue="") String keyword
                                ){

        Page<Stockroom> stockrooms = stockroomManager.searchStockroom(keyword, page, taille);
        model.addAttribute("stockrooms", stockrooms.getContent());
        int[] pages = new int[stockrooms.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "indexStockroom";


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

    @GetMapping("/deleteStockroom")
    public String deleteStockroom(@RequestParam(name="id") Integer id){
        stockroomManager.deleteStockroom(id);
        return "redirect:indexStockroom";
    }




}
