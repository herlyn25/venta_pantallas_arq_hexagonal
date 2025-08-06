package com.example.pruebahexgonal.demo.application.services;

import java.util.*;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.domain.ports.ClientRepositoryPort;

public class ClientServices {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientServices(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public Clients createCliente(Clients client){
        return clientRepositoryPort.create(client);
    }

    public List<Clients> findAll(){
        return clientRepositoryPort.findAll();
    }

    public Optional<Clients> findById(Long id){
        return clientRepositoryPort.findById(id);
    }
    
    
}
