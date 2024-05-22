package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    public Page<Supplier> findSupplierBySupplierNameContainingIgnoreCase(String keyword, Pageable pageable);
}
