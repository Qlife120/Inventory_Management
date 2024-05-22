package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Order;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
    public Order searchOrderByOrderId(Integer id);
}
