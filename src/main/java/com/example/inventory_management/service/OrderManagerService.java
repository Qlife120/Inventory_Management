package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Order;
import com.example.inventory_management.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderManagerService implements OrderManager{

    @Autowired
    public OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Integer id) {
        try {
            orderRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Page<Order> getAllOrders(int page, int taille) {
        return orderRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Order searchOrderByorderId(Integer id) {

        return orderRepository.searchOrderByOrderId(id);
    }
}
