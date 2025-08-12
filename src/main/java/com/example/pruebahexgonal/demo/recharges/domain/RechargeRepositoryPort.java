package com.example.pruebahexgonal.demo.recharges.domain;

import java.util.*;

public interface RechargeRepositoryPort {
    public Recharges save(Recharges client);
    public List <Recharges> findAll();
    public Optional<Recharges> findById(Long id);   
    public void delete(Long id);
    public boolean existsById(Long id);  
}