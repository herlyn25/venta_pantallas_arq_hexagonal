package com.example.pruebahexgonal.demo.sales.infra.persistence;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;
import com.example.pruebahexgonal.demo.sales.domain.Sales;

@Component
public class SalesMapper {
    public Sales toDomain(SalesEntity entity){
        if (entity == null) return null;
        Sales sales = new Sales();
        sales.setId(entity.getId());
        sales.setDescription(entity.getDescription());
        sales.setValorCompra(entity.getValorCompra());
        sales.setValorVenta(entity.getValorVenta());       
        sales.setFechaCompra(entity.getFechaCompra());
        
        if(entity.getClient() != null) {
            Clients clients = new Clients(
                entity.getClient().getId(),
                entity.getClient().getFirstname(),
                entity.getClient().getLastname(),
                entity.getClient().getEmail());
                sales.setCliente(clients);
        }           
        return sales;
    }
    
    public SalesEntity toEntity(Sales sales){
        if (sales == null) return null;

        SalesEntity entity = new SalesEntity();
        entity.setId(sales.getId());
        entity.setDescription(sales.getDescription());
        entity.setValorCompra(sales.getValorCompra());
        entity.setValorVenta(sales.getValorVenta());      
        entity.setFechaCompra(sales.getFechaCompra());

        // ✅ Solo asigna el cliente si tiene ID, y crea una referencia parcial
        if (sales.getCliente() != null && sales.getCliente().getId() != null) {
            ClientsEntity client = new ClientsEntity();
            client.setId(sales.getCliente().getId()); // Solo el ID
            entity.setClient(client); // JPA entenderá que es una referencia existente
        }
        return entity;
    }

    public Sales fromDTOtoDomain(SalesDto dto){
        Sales sales = new Sales();
        sales.setDescription(dto.description());
        sales.setValorCompra(dto.valorCompra());
        sales.setValorVenta(dto.valorVenta());        
        Clients client = new Clients();
        client.setId(dto.clientId());
        sales.setCliente(client);
        return sales;
    }

    public Sales fromUpdateDTOtoDomain(SalesUpdateDTO dto){
        Sales sales = new Sales();
        sales.setDescription(dto.getDescription());
        sales.setValorCompra(dto.getValorCompra());
        sales.setValorVenta(dto.getValorVenta());        
        sales.setFechaCompra(dto.getFechaCompra());
        Clients client = new Clients();
        client.setId(dto.getClientId());
        sales.setCliente(client);
        return sales;
    }
}