package com.example.inventory_management.dao.repositories;

import ch.qos.logback.core.model.INamedModel;
import com.example.inventory_management.dao.entities.Stockroom;
import jakarta.transaction.Transactional;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface StockroomRepository extends JpaRepository<Stockroom, Integer> {
    public Page<Stockroom> findByStockroomNameContainingIgnoreCase(String keyword, Pageable pageable);
}
