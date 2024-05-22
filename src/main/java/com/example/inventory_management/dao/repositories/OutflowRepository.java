package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Outflow;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OutflowRepository  extends JpaRepository<Outflow, Integer> {
    public Outflow findOutflowByOutflowCode(Integer id);

}
