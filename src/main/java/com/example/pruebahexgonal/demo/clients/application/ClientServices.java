package com.example.pruebahexgonal.demo.clients.application;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebahexgonal.demo.clients.domain.ClientRepositoryPort;
import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.exception.*;

@Service
public class ClientServices {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientServices(ClientRepositoryPort clientRepositoryPort) {
                this.clientRepositoryPort = clientRepositoryPort;
      
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
            ()-> new CustomException(id,"client")
        );
    } 
    
    @Transactional
    public Clients updateClient(Long id, Clients incoming){
        Clients current = findClientsById(id);
        if(current == null) throw new CustomException(id,"Client");
        
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
        if (!clientRepositoryPort.existsById(id)) throw new CustomException(id,"client");
        clientRepositoryPort.delete(id);
    }    
}