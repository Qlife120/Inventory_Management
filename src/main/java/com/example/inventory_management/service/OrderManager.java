package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

@Transactional
public interface OrderManager {
    public Order addOrder(Order order);
    public  Order updateOrder(Order order);
    public boolean deleteOrder(Integer id);
    public Page<Order> getAllOrders(int page, int taille);
    public Order searchOrderByorderId(Integer id);
}
