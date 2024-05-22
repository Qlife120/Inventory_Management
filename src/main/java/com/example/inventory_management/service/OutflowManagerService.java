package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Outflow;
import com.example.inventory_management.dao.repositories.OutflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OutflowManagerService implements OutflowManager{

    @Autowired
    public OutflowRepository outflowRepository;


    @Override
    public Outflow addOutflow(Outflow outflow) {
        return outflowRepository.save(outflow);
    }

    @Override
    public boolean deleteOutflow(Integer id) {
        try{
            outflowRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Outflow updateOutflow(Outflow outflow) {
        return outflowRepository.save(outflow);
    }

    @Override
    public Page<Outflow> getAllOutflow(int page, int taille) {
        return outflowRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Outflow searchOutflowById(Integer id) {
        return outflowRepository.findOutflowByOutflowCode(id);
    }
}
