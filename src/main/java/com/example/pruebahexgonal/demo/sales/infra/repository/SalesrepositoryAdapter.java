package com.example.pruebahexgonal.demo.sales.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;
import com.example.pruebahexgonal.demo.clients.infra.repository.JpaClientRepository;
import com.example.pruebahexgonal.demo.exception.CustomException;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.domain.SalesRepositoryPort;
import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesEntity;
import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesMapper;

@Service
public class SalesrepositoryAdapter implements SalesRepositoryPort{

    private final JpaSalesRepository jpaSalesRepository;
    private final JpaClientRepository jpaClientRepository;
    private final SalesMapper salesMapper;

    public SalesrepositoryAdapter(
        JpaSalesRepository jpaSalesRepository,
        JpaClientRepository jpaClientRepository, 
        SalesMapper salesMapper) {
        this.jpaSalesRepository = jpaSalesRepository;
        this.jpaClientRepository=jpaClientRepository;
        this.salesMapper = salesMapper;
    }    

    @Override
    public Sales save(Sales sale) {
        SalesEntity entity = (sale.getId() != null) 
                                ? jpaSalesRepository.findById(sale.getId()).orElse(new SalesEntity())
                                : new SalesEntity ();
            entity.setId(sale.getId());
            entity.setDescription(sale.getDescription());
            entity.setValorCompra(sale.getValorCompra());
            entity.setValorVenta(sale.getValorVenta());
            entity.setFechaCompra(sale.getFechaCompra());
        ClientsEntity entityClient = (sale.getCliente().getId()!=null)
                                        ? jpaClientRepository.findById(sale.getCliente().getId()).orElse(new ClientsEntity())
                                        : new ClientsEntity();
                    entityClient.setId(sale.getCliente().getId());
            entity.setClient(entityClient); 
            
        SalesEntity salesSaved = jpaSalesRepository.save(entity);


            return salesMapper.toDomain(salesSaved);
       
    }

    @Override
    public Sales findById(Long id) {
        Sales sales = salesMapper.toDomain(jpaSalesRepository.findById(id).orElseThrow(
            ()-> new CustomException(id,"sales"))         
        );
        return sales;
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
}