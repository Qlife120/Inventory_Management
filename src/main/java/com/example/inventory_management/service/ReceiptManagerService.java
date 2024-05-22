package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Receipt;
import com.example.inventory_management.dao.repositories.ProductRepository;
import com.example.inventory_management.dao.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReceiptManagerService implements ReceiptManager{

    @Autowired
    public ReceiptRepository receiptRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Receipt addReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public boolean deleteReceipt(Integer id) {
        try{
            receiptRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public Page<Receipt> getAllReceipt(int page, int taille) {
        return receiptRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Receipt searchReceiptById(Integer id) {
        return receiptRepository.findReceiptByReceiptCode(id);
    }
}