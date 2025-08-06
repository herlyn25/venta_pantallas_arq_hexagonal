package com.example.pruebahexgonal.demo.infra.entities;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;

public class ClientsEntity extends Clients {

    public ClientsEntity(Long id, String firstname, String lastname, String email) {
        super(id, firstname, lastname, email);        
    }    
}
