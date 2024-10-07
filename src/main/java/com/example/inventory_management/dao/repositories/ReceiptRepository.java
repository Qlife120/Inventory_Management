package com.example.inventory_management.dao.repositories;

import com.example.inventory_management.dao.entities.Receipt;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    public Receipt findReceiptByReceiptCode(Integer id);
    public List<Receipt> findReceiptByIsdeletedFalse();
}
