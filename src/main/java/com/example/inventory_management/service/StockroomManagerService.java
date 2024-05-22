package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Stockroom;
import com.example.inventory_management.dao.repositories.StockroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockroomManagerService implements StockroomManager{

    @Autowired
    public StockroomRepository stockroomRepository;

    @Override
    public Stockroom addStockroom(Stockroom stockroom) {
        return stockroomRepository.save(stockroom);
    }

    @Override
    public Stockroom updateStockroom(Stockroom stockroom) {
        return stockroomRepository.save(stockroom);
    }

    @Override
    public boolean deleteStockroom(Integer id) {
        try{
            stockroomRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Page<Stockroom> getAllStockroom(int page, int taille) {
        return stockroomRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Stockroom> searchStockroom(String keyword, int page, int taille) {
        return stockroomRepository.findByStockroomNameContainingIgnoreCase(keyword, PageRequest.of(page, taille));
    }

    @Override
    public List<Stockroom> getAllStockrooms(){
        return stockroomRepository.findAll();
    }

    @Override
    public Stockroom getStockroomById(Integer id){
        Optional<Stockroom> optional = stockroomRepository.findById(id);
        Stockroom stockroom = null;
        if(optional.isPresent()){
            stockroom=optional.get();

        }
        else{
            throw new RuntimeException("Stockroom not found for id: " + id);
        }
        return stockroom;
    }
}
