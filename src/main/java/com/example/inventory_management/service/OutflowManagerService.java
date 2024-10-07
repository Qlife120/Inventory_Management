package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Outflow;
import com.example.inventory_management.dao.repositories.OutflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
            Outflow outflow = outflowRepository.findById(id).orElseThrow(()-> new RuntimeException("outflow not found for the id: " + id));
            outflow.setIsdeleted(true);
            outflowRepository.save(outflow);
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
    public List<Outflow> getAllOutflows(){
        return outflowRepository.findAll();
    }

    @Override
    public Outflow searchOutflowById(Integer id) {
        return outflowRepository.findOutflowByOutflowCode(id);
    }
}
