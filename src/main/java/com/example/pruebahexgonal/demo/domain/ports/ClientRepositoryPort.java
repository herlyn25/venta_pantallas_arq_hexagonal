package com.example.pruebahexgonal.demo.domain.ports;

import java.util.*;
import com.example.pruebahexgonal.demo.domain.pojo.Clients;

public interface ClientRepositoryPort {
    public Clients save(Clients client);
    public List <Clients> findAll();
    public Optional<Clients> findById(Long id);   
    public void delete(Long id);
    public boolean existsById(Long id);   
     boolean existsByEmail(String email);
}