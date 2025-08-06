package com.example.pruebahexgonal.demo.infra.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.domain.ports.ClientRepositoryPort;

@Component
public class ClientsRepositoryAdapter implements ClientRepositoryPort{

    private List<Clients> clients = new ArrayList<>();

    public ClientsRepositoryAdapter(){
        clients.add(new Clients(
            1L, "Herlyn", 
            "Castillo","h@h.com")); 
    }

    @Override
    public Clients create(Clients client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Clients> findAll() {
        return clients;
    }

    @Override
    public Optional<Clients> findById(Long id) {
        return clients.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
            
    }      
}

