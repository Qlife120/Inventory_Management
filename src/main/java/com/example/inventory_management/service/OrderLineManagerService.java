package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.OrderLine;
import com.example.inventory_management.dao.repositories.OrderLineRepository;
import com.example.inventory_management.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderLineManagerService implements OrderLineManager{

    @Autowired
    public OrderLineRepository orderLineRepository;

    @Override
    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine updateOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public boolean deleteOrderLine(Integer id) {
        try{
            orderLineRepository.deleteById(id);
            return false;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return true;
        }
    }

    @Override
    public Page<OrderLine> getAllOrderLine(int page, int taille) {
        return orderLineRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<OrderLine> serachOrderLineById(Integer id, int page, int taille) {
        return orderLineRepository.findOrderLineByOrderlineIdContaining(id, PageRequest.of(page,taille));
    }
}
