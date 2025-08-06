package com.example.pruebahexgonal.demo.domain.ports;

import java.util.*;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;

public interface ClientRepositoryPort {
    public Clients create(Clients client);
    public List <Clients> findAll();
    public Optional<Clients> findById(Long id);
}
    
