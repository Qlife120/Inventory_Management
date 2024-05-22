package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Stockroom;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

import java.util.List;

@Transactional
public interface StockroomManager {
    public Stockroom addStockroom(Stockroom stockroom);
    public Stockroom updateStockroom(Stockroom stockroom);
    public boolean deleteStockroom(Integer id);
    public Page<Stockroom> getAllStockroom(int page, int taille);
    public List<Stockroom> getAllStockrooms();
    public Page<Stockroom> searchStockroom(String keyword, int page, int taille);
    public Stockroom getStockroomById(Integer id);

}
