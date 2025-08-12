package com.example.pruebahexgonal.demo.sales.infra.persistence;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;
import com.example.pruebahexgonal.demo.sales.domain.Sales;

@Component
public class SalesMapper {
    public Sales toDomain(SalesEntity entity){
        if (entity == null) return null;
        Sales sales = new Sales(   
            entity.getId(),         
            entity.getDescription(),
            entity.getValorCompra(),
            entity.getValorVenta(), 
            entity.getClient().getId(),      
            entity.getFechaCompra()    
        );                
        return sales;
    }
    
    public SalesEntity toEntity(Sales sales){
        if (sales == null) return null;

        SalesEntity entity = new SalesEntity();
        entity.setId(sales.getId());
        entity.setDescription(sales.getDescription());
        entity.setValorCompra(Integer.valueOf(sales.getValorCompra()));
        entity.setValorVenta(Integer.valueOf(sales.getValorVenta()));      
        entity.setFechaCompra(sales.getFechaCompra());

        // ✅ Solo asigna el cliente si tiene ID, y crea una referencia parcial
        if (sales.getClientId() != null) {
            ClientsEntity client = new ClientsEntity();
            client.setId(sales.getClientId()); // Solo el ID
            entity.setClient(client); // JPA entenderá que es una referencia existente
        }
        return entity;
    }

    public Sales fromDTOtoDomain(SalesDto dto){
        Sales sales = new Sales();
        sales.setDescription(dto.description());
        sales.setValorCompra(Integer.valueOf(dto.valorCompra()));
        sales.setValorVenta(Integer.valueOf(dto.valorVenta()));        
        Clients client = new Clients();
        client.setId(dto.clientId());
        sales.setClientId(client.getId());
        return sales;
    }

    public Sales fromUpdateDTOtoDomain(Long id,SalesUpdateDTO dto){
        Sales sales = new Sales();
        sales.setId(id);
        sales.setDescription(dto.getDescription());
        sales.setValorCompra(dto.getValorCompra());
        sales.setValorVenta(dto.getValorVenta());        
        sales.setFechaCompra(dto.getFechaCompra());        
        sales.setClientId(dto.getClientId());
        return sales;
    }

    
}