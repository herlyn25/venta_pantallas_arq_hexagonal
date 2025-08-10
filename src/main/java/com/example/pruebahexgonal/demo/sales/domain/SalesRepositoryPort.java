package com.example.pruebahexgonal.demo.sales.domain;

import java.util.List;

public interface SalesRepositoryPort {
    Sales save(Sales sale);
    Sales findById(Long id);
    List<Sales> findAll();
    void deleteById(Long id); 
    boolean existsById(Long id);    
} 
