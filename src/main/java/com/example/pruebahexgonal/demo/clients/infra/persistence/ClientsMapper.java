package com.example.pruebahexgonal.demo.clients.infra.persistence;

import org.springframework.stereotype.Component;
import com.example.pruebahexgonal.demo.clients.domain.Clients;

@Component
public class ClientsMapper {
     public static Clients toDomain(ClientsEntity entity){     
        if(entity== null) return null;        
        Clients clients = new Clients(
            entity.getId(),
            entity.getFirstname(),
            entity.getLastname(),
            entity.getEmail());                  
        return clients;
    }
    
    public static ClientsEntity toEntity(Clients client){
        if (client == null) return null;
        ClientsEntity entity = new ClientsEntity();
        entity.setId(client.getId());
        entity.setFirstname(client.getFirstname());
        entity.setLastname(client.getLastname());
        entity.setEmail(client.getEmail());       
        return entity;
    }

    public static Clients fromDTOtoDomain(ClientsEntityDTO dto){
        Clients client = new Clients();
        client.setFirstname(dto.getFirstname());
        client.setLastname(dto.getLastname());
        client.setEmail(dto.getEmail());        
        return client;
    }

    public static Clients fromUpdateDTOtoDomain(ClientsEntityUpdateDTO dto){
        Clients client = new Clients();
        client.setFirstname(dto.getFirstname());
        client.setLastname(dto.getLastname());
        client.setEmail(dto.getEmail());        
        return client;
    }
}