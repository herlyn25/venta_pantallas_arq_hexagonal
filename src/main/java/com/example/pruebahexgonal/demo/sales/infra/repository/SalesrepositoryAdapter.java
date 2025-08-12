package com.example.pruebahexgonal.demo.sales.infra.repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;
import com.example.pruebahexgonal.demo.clients.infra.repository.JpaClientRepository;
import com.example.pruebahexgonal.demo.exception.CustomException;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.domain.SalesRepositoryPort;
import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesEntity;
import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesMapper;

@Service
public class SalesRepositoryAdapter implements SalesRepositoryPort{

    private final JpaSalesRepository jpaSalesRepository;
    private final JpaClientRepository jpaClientRepository;
    private final SalesMapper salesMapper;

    public SalesRepositoryAdapter(
        JpaSalesRepository jpaSalesRepository,
        JpaClientRepository jpaClientRepository, 
        SalesMapper salesMapper) {
        this.jpaSalesRepository = jpaSalesRepository;
        this.jpaClientRepository=jpaClientRepository;
        this.salesMapper = salesMapper;
    }    

    @Override
    public Sales save(Sales sale) {                                       
        ClientsEntity entityClient = jpaClientRepository.findById(sale.getClientId())
                            .orElse(new ClientsEntity());
            
        if (entityClient.getId()==null) throw new CustomException(sale.getClientId(),"Client");          
        entityClient.setId(sale.getClientId());
        
        SalesEntity salesEntity = new SalesEntity();
        salesEntity.setDescription(sale.getDescription());
        salesEntity.setValorCompra(sale.getValorCompra());
        salesEntity.setValorVenta(sale.getValorVenta());
        salesEntity.setFechaCompra((sale.getFechaCompra()==null) ? LocalDate.now() : sale.getFechaCompra());
        salesEntity.setClient(entityClient);
            
        SalesEntity salesSaved = jpaSalesRepository.save(salesEntity);
        return salesMapper.toDomain(salesSaved);       
    }

    @Override
    public Optional<Sales> findById(Long id) {        
        return jpaSalesRepository.findById(id).map(salesMapper::toDomain);
    }

    @Override
    public List<Sales> findAll() {
        return jpaSalesRepository.findAll().stream()
                .map(salesMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaSalesRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaSalesRepository.existsById(id);
    }

    @Override
    public Sales update(Long id, Sales sale) {
        SalesEntity salesEntity = jpaSalesRepository.findById(id).orElseThrow(
                                    () -> new CustomException(id, "Sales")
        );               
               
        if (sale.getDescription() !=null) salesEntity.setDescription(sale.getDescription());
        if (sale.getValorCompra() !=null) salesEntity.setValorCompra(sale.getValorCompra());
        if (sale.getValorVenta() !=null) salesEntity.setValorVenta(sale.getValorVenta());
        salesEntity.setFechaCompra((sale.getFechaCompra()==null) ? LocalDate.now() : sale.getFechaCompra());        
        
        if (sale.getClientId() != null){
            ClientsEntity clientsEntity = new ClientsEntity();
            clientsEntity.setId(sale.getClientId());
            salesEntity.setClient(clientsEntity);
        } 
        SalesEntity updatedSales = jpaSalesRepository.save(salesEntity);
        return salesMapper.toDomain(updatedSales);
    }    
}