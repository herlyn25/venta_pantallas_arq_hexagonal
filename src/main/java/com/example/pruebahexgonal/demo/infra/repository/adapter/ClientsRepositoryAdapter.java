package com.example.pruebahexgonal.demo.infra.repository.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.domain.ports.ClientRepositoryPort;
import com.example.pruebahexgonal.demo.infra.entities.ClientsEntity;
import com.example.pruebahexgonal.demo.infra.repository.jpa.JpaClientRepository;

@Component
public class ClientsRepositoryAdapter implements ClientRepositoryPort{

    private final JpaClientRepository jpaClientRepository;

    public ClientsRepositoryAdapter(JpaClientRepository jpaClientRepository){
        this.jpaClientRepository=jpaClientRepository;
    }

    @Override
    public Clients save(Clients client) {
        ClientsEntity entity = (client.getId() !=null ) 
                                ? jpaClientRepository.findById(client.getId()).orElse(new ClientsEntity())
                                : new ClientsEntity();
            entity.setId(client.getId());
            entity.setFirstname(client.getFirstname());
            entity.setLastname(client.getLastname());
            entity.setEmail(client.getEmail());
            
            ClientsEntity clientSaved = jpaClientRepository.save(entity);
            return toDomain(clientSaved);
    }

    @Override
    public List<Clients> findAll() {
        return jpaClientRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Clients> findById(Long id) {
        return jpaClientRepository.findById(id).map(this::toDomain);                 
    }  

    @Override
    public void delete(Long id) {
        jpaClientRepository.deleteById(id);;
    }

    @Override
    public boolean existsById(Long id) {
        return jpaClientRepository.existsById(id);
    }

     private Clients toDomain(ClientsEntity entity){
        return new Clients(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getEmail());
    }

     @Override
     public boolean existsByEmail(String email) {
        return jpaClientRepository.existsByEmail(email);
     }
   
}