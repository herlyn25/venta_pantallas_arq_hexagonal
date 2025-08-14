package com.example.pruebahexgonal.demo.clients.infra.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pruebahexgonal.demo.clients.application.ClientServices;
import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.clients.infra.persistence.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.*;


@RestController
@RequestMapping("clients")
@Tag (name= "clients resource")
public class ClientsController {
    
    private final ClientServices clientsServices;
   
    ClientsController(ClientServices clientsServices) {
        this.clientsServices = clientsServices;
    }

     @Operation(summary = "Post in DB a client given throught from body")
    @PostMapping("register")
    public Clients create(@Valid @RequestBody ClientsEntityDTO entity) {     
        return clientsServices.createClient(ClientsMapper.fromDTOtoDomain(entity));
    }

    @Operation(summary = "Get all clients saved in the DB")
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

    @Operation(summary = "get a client by id saved in the DB")
    @GetMapping("/{id}")
    public ResponseEntity<Clients> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientsServices.findClientsById(id));    
    }     

    @Operation(summary = "Update a client by id saved in the DB")
    @PutMapping("update/{id}")
    public ResponseEntity<Clients> update(@PathVariable Long id, @RequestBody ClientsEntityUpdateDTO clientUpdate) {
       Clients updated = clientsServices.updateClient(id, ClientsMapper.fromUpdateDTOtoDomain(clientUpdate));
       return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete a client by id saved in the DB")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientsServices.deleteClients(id);
        return ResponseEntity.noContent().build();
    }
}