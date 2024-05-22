package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.OrderLine;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    public Page<OrderLine> findOrderLineByOrderlineIdContaining(Integer id, Pageable pageable);
}
