package com.example.inventory_management.web;

import com.example.inventory_management.dao.entities.Outflow;
import com.example.inventory_management.service.OutflowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OutflowController {

    @Autowired
    private OutflowManager outflowManager;

    @GetMapping("/indexOutflow")
    public String outflowList(Model model){
        List<Outflow> outflows = outflowManager.getAllOutflows();
        model.addAttribute("outflows", outflows);
        return "indexOutflow";
    }

    @GetMapping("/addOutflowForm")
    public String addOutflowForm(Model model){
        Outflow newOutflow = new Outflow();
        model.addAttribute("newOutflow", newOutflow);
        return "OutflowForm";
    }

    @PostMapping("addOutflow")
    public String addOutflow(@ModelAttribute(name = "newOutflow") Outflow newOutflow){
        outflowManager.addOutflow(newOutflow);
        return "redirect:indexOutflow";
    }

    // Soft Delete
    @GetMapping("/deleteOuflow/{id}")
    public String deleteOutflow(@PathVariable(name = "id") Integer id){
        if(outflowManager.deleteOutflow(id)){
            return "redirect:indexOutflow";
        }else{
            return "errorOutflow";
        }


    }

}
