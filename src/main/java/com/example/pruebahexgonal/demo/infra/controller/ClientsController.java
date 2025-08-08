package com.example.pruebahexgonal.demo.infra.controller;

import com.example.pruebahexgonal.demo.application.services.ClientServices;
import com.example.pruebahexgonal.demo.domain.pojo.Clients;
import com.example.pruebahexgonal.demo.infra.dto.ClientsEntityUpdateDTO;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("clients")
public class ClientsController {
    
    private final ClientServices clientsServices;

    ClientsController(ClientServices clientsServices) {
        this.clientsServices = clientsServices;
    }

    @PostMapping("register")
    public Clients create(@Valid @RequestBody Clients entity) {     
        return clientsServices.createClient(entity);
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> getAllClients() {
        List<Clients> clients = clientsServices.findAll();
        Map<String, Object> response = new HashMap<>();
        
        if(clients.isEmpty()){           
            response.put("message", "No clients found");
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }            
        response.put("data", clients);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientsServices.findClientsById(id));    
    }     

    @PutMapping("update/{id}")
    public ResponseEntity<Clients> update(@PathVariable Long id, @RequestBody ClientsEntityUpdateDTO entity) {
       Clients updated = clientsServices.update(id, new Clients(id, entity.getFirstname(), entity.getLastname(), entity.getEmail()));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientsServices.deleteClients(id);
        return ResponseEntity.noContent().build();
    }
}