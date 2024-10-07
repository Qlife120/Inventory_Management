package com.example.inventory_management.web;

import com.example.inventory_management.dao.entities.Supplier;
import com.example.inventory_management.service.SupplierManager;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SupplierController{

	@Autowired
	public SupplierManager supplierManager;

	@GetMapping("/indexSupplier")
	public String SupplierList(Model model,
								@RequestParam(name="page", defaultValue="0") int page,
								@RequestParam(name="taille", defaultValue="6") int taille,
								@RequestParam(name="search", defaultValue="") String keyword	
								){

		Page<Supplier> suppliers = supplierManager.searchSupplier(keyword,page,taille);
		model.addAttribute("suppliers", suppliers.getContent());
		int[] pages = new int[suppliers.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "indexSupplier";



	}

	@GetMapping("/addSupplierForm")
	public String addSupplierForm(Model model){

		Supplier supplier  = new Supplier();
		model.addAttribute(supplier);
		return "SupplierForm";		
	}

	@PostMapping("/addSupplier")
	public String addSupplier(Model model,@ModelAttribute(name="supplier") Supplier supplier){
		supplierManager.addSupplier(supplier);
		return "redirect:indexSupplier";

	}

	@GetMapping("/updateSupplier")
	public String updateSupplier(Model model, @RequestParam(name="id") Integer id){
		
		Supplier supplierToBeUpdated = supplierManager.getSupplierById(id);
		
		model.addAttribute("supplierToBeUpdated", supplierToBeUpdated);
		return "Update_Supplier";


	}

	@GetMapping("/deleteSupplier")
	public String deleteSupplier(@RequestParam(name="id") Integer id){

		if(supplierManager.deleteSupplier(id)){
			return "redirect:indexSupplier";
		}
		else{
			return "errorSupplier";
		}
	}

}