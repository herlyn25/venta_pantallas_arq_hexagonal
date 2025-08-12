package com.example.pruebahexgonal.demo.sales.application;

import java.util.*;
import org.springframework.stereotype.Service;

import com.example.pruebahexgonal.demo.exception.CustomException;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.domain.SalesRepositoryPort;

import jakarta.transaction.Transactional;

@Service
public class SalesServices {
    private final SalesRepositoryPort salesPort;

    public SalesServices(SalesRepositoryPort salesPort) {
        this.salesPort = salesPort;        
    }
    
    @Transactional
    public Sales createSales(Sales sale){
       return salesPort.save(sale);
    }

    @Transactional
    public List<Sales> findSalesAll(){
        return salesPort.findAll();
    }
    
    @Transactional
    public Sales findSaleById(Long id){
        return salesPort.findById(id).orElseThrow(
            ()-> new CustomException(id, "Sales")
            );
    }

    @Transactional
    public void deleteSaleById(Long id){
        if(!salesPort.existsById(id)) throw new CustomException(id,"sales");
        salesPort.deleteById(id);
    }

    @Transactional
    public Sales updateSales(Long id, Sales sale){        
        return salesPort.update(id, sale);         
    }
}