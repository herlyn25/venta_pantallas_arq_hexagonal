package com.example.pruebahexgonal.demo.infra.controller;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.infra.adapters.ClientsRepositoryAdapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientsController {
    private final ClientsRepositoryAdapter clientsRepositoryAdapter = new ClientsRepositoryAdapter();

    @PostMapping("register")
    public Clients createClients(@RequestBody Clients entity) {     
        return clientsRepositoryAdapter.create(entity);
    }

    @GetMapping("all")
    public List<Clients> getAllClients() {
        return clientsRepositoryAdapter.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientsById(@PathVariable Long id) {
        return clientsRepositoryAdapter.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    
    }     
}