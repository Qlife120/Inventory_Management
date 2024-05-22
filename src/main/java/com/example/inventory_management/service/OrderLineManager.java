package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.OrderLine;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

@Transactional
public interface OrderLineManager {
    public OrderLine addOrderLine(OrderLine orderLine);
    public OrderLine updateOrderLine(OrderLine orderLine);
    public boolean deleteOrderLine(Integer id);
    public Page<OrderLine> getAllOrderLine(int page, int taille);
    public Page<OrderLine> serachOrderLineById(Integer id, int page, int taille);
}
