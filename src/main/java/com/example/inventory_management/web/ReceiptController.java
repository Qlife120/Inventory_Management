package com.example.inventory_management.web;

import com.example.inventory_management.dao.entities.Receipt;
import com.example.inventory_management.dao.entities.Stockroom;
import com.example.inventory_management.service.ReceiptManager;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReceiptController {

    @Autowired
    public ReceiptManager receiptManager;

    @GetMapping("/indexReceipt")
    public String Receiptlist(Model model){
        List<Receipt> receipts  = receiptManager.getAllReceiptsList();
        model.addAttribute("receipts",receipts);
        return "indexReceipt";
    }

    @GetMapping("/addReceiptForm")
    public String addReceiptForm(Model model){
        Receipt newReceipt = new Receipt();
        model.addAttribute("newReceipt", newReceipt);
        return "ReceiptForm";
    }

    @PostMapping("/addReceipt")
    public String addReceipt(@ModelAttribute(name = "newReceipt") Receipt receipt){
        receiptManager.addReceipt(receipt);
        return "redirect:indexReceipt";
    }

    @GetMapping("/updateReceipt/{id}")
    public String updateReceipt(@PathVariable(name="id") Integer id, Model model){
        Receipt receiptToBeUpdated = receiptManager.getReceiptById(id);
        model.addAttribute("receiptToBeUpdated", receiptToBeUpdated);
        return "Update_Receipt";

    }

    // Perform Soft Delete: Instead of deleting the record from the database

    @GetMapping("/deleteReceipt")
    public String deleteReceipt(@RequestParam(name = "id") Integer id){
        receiptManager.deleteReceipt(id);
        return "redirect:indexReceipt";

    }

}
