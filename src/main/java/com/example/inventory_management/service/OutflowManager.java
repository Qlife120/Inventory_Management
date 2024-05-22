package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Outflow;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface OutflowManager {

    public Outflow addOutflow(Outflow outflow);
    public boolean deleteOutflow(Integer id);
    public Outflow updateOutflow(Outflow outflow);
    public Page<Outflow> getAllOutflow(int page, int taille);
    public Outflow searchOutflowById(Integer id);

}
