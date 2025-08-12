package com.example.pruebahexgonal.demo.sales.domain;

import java.util.*;

public interface SalesRepositoryPort {
    Sales save(Sales sale);
    Optional<Sales> findById(Long id);
    List<Sales> findAll();
    void deleteById(Long id); 
    boolean existsById(Long id); 
    Sales update(Long id, Sales sale);   
} 
