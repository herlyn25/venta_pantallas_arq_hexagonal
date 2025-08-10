package com.example.pruebahexgonal.demo.sales.infra.controller;

import org.springframework.web.bind.annotation.*;

import com.example.pruebahexgonal.demo.sales.application.SalesServices;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.infra.persistence.*;
import com.example.pruebahexgonal.demo.sales.infra.repository.JpaSalesRepository;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("sales")
public class SalesController {

    private final SalesServices salesServices;
    private final SalesMapper salesMapper;    

    public SalesController(SalesServices salesServices, SalesMapper salesMapper, JpaSalesRepository jpaSalesRepository) {
        this.salesServices = salesServices;
        this.salesMapper= salesMapper;
    }

    @PostMapping("register")
    public Sales postMethodName(@Valid @RequestBody SalesDto entity) {
       return salesServices.createSales(salesMapper.fromDTOtoDomain(entity));    
    }    

    @GetMapping("all")
    public List<Sales> findAllSales() {
        return salesServices.findAll();
    } 
    
    @GetMapping("/{id}")
    public Sales getMethodName(@PathVariable Long id) {
        return salesServices.findSalesById(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        salesServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,  @RequestBody SalesUpdateDTO entity) {      
        Sales updated = salesServices.update(id, salesMapper.fromUpdateDTOtoDomain(entity));
        return ResponseEntity.ok(updated);
    }
}