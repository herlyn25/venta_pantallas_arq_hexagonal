package com.example.pruebahexgonal.demo.clients.domain;

import java.util.*;

public interface ClientRepositoryPort {
    public Clients save(Clients client);
    public List <Clients> findAll();
    public Optional<Clients> findById(Long id);   
    public void delete(Long id);
    public boolean existsById(Long id);   
    boolean existsByEmail(String email);
}