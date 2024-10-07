package com.example.inventory_management.service;

import com.example.inventory_management.dao.entities.Receipt;
import com.example.inventory_management.dao.repositories.ProductRepository;
import com.example.inventory_management.dao.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptManagerService implements ReceiptManager{

    @Autowired
    public ReceiptRepository receiptRepository;

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
            Receipt reception = receiptRepository.findById(id).orElseThrow(()-> new RuntimeException("Reception not found for the id:" + id));
            reception.setIsdeleted(true);
            receiptRepository.save(reception);
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

    @Override
    public List<Receipt> getAllReceiptsList(){
        return  receiptRepository.findReceiptByIsdeletedFalse();
    }

    @Override
    public Receipt getReceiptById(Integer id){
        Optional<Receipt> optional = receiptRepository.findById(id);
        Receipt receipt;
        if(optional.isPresent()){
            receipt = optional.get();
        }
        else{
            throw new RuntimeException("Rceiption not found for id: " +id);
        }
        return receipt;
    }
}