package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Receipt;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

@Transactional
public interface ReceiptManager {
    public Receipt addReceipt(Receipt receipt);
    public Receipt updateReceipt(Receipt receipt);
    public boolean deleteReceipt(Integer id);
    public Page<Receipt> getAllReceipt(int page, int taille);
    public Receipt searchReceiptById(Integer id);
}
