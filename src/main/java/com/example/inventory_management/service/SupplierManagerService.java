package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Supplier;
import com.example.inventory_management.dao.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierManagerService implements SupplierManager{

    @Autowired
    public SupplierRepository supplierRepository;

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public boolean deleteSupplier(Integer id) {
        try{
            supplierRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Page<Supplier> getAllSuppliers(int page, int taille) {
        return supplierRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Supplier> searchSupplier(String keyword, int page, int taille) {
        return supplierRepository.findBySupplierNameContainingIgnoreCase(keyword, PageRequest.of(page,taille));
    }

    @Override
    public Supplier getSupplierById(Integer id){

        return supplierRepository.findById(id).get();
        


    }

    @Override
    public List<Supplier> getSuppliersList(){

        return supplierRepository.findAll();
    }
}
