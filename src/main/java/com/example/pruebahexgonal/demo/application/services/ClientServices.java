package com.example.pruebahexgonal.demo.application.services;

import java.util.*;
import com.example.pruebahexgonal.demo.infra.repository.adapter.ClientsRepositoryAdapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebahexgonal.demo.application.exception.CustomException;
import com.example.pruebahexgonal.demo.application.exception.EmailAlreadyUsedException;
import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.domain.ports.ClientRepositoryPort;

@Service
public class ClientServices {

    private final ClientsRepositoryAdapter clientsRepositoryAdapter;
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientServices(ClientRepositoryPort clientRepositoryPort, ClientsRepositoryAdapter clientsRepositoryAdapter) {
        this.clientRepositoryPort = clientRepositoryPort;
        this.clientsRepositoryAdapter = clientsRepositoryAdapter;
    }

    @Transactional
    public Clients createClient(Clients client){
        if(clientRepositoryPort.existsByEmail(client.getEmail())){
            throw new EmailAlreadyUsedException(client.getEmail());
        }
        client.setId(null);
        return clientRepositoryPort.save(client);
    }

    @Transactional(readOnly = true)
    public List<Clients> findAll(){
        return clientRepositoryPort.findAll();
    }

    @Transactional(readOnly = true)
    public Clients findClientsById(Long id){
        return clientRepositoryPort.findById(id).orElseThrow(
            ()-> new CustomException(id)
        );
    } 
    
    @Transactional
    public Clients update(Long id, Clients incoming){
        Clients current = findClientsById(id);
        if (incoming.getFirstname() !=null ) current.setFirstname(incoming.getFirstname());     
        if (incoming.getLastname() !=null ) current.setLastname(incoming.getLastname()); 
        if (incoming.getEmail() !=null ){
            if(clientRepositoryPort.existsByEmail(incoming.getEmail())){
                throw new EmailAlreadyUsedException(incoming.getEmail());
            }
            current.setEmail(incoming.getEmail());
        }      
        return clientRepositoryPort.save(current);
    }

    public void deleteClients(Long id){
        if (!clientRepositoryPort.existsById(id)){
            throw new CustomException(id);
        }
        clientRepositoryPort.delete(id);
    }    
}