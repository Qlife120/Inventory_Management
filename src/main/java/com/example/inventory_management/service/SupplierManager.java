package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import java.util.List;
@Transactional
public interface SupplierManager {
    public Supplier addSupplier(Supplier supplier);
    public Supplier updateSupplier(Supplier supplier);
    public boolean deleteSupplier(Integer id);
    public Page<Supplier> getAllSuppliers(int page, int taille);
    public Page<Supplier> searchSupplier(String keyword, int page, int taille);
    public List<Supplier> getSuppliersList();
    public Supplier getSupplierById(Integer id);
}
