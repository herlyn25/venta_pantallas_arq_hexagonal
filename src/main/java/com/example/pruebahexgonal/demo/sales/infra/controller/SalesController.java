package com.example.pruebahexgonal.demo.sales.infra.controller;

import org.springframework.web.bind.annotation.*;

import com.example.pruebahexgonal.demo.sales.application.SalesServices;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.infra.persistence.*;
import com.example.pruebahexgonal.demo.sales.infra.repository.JpaSalesRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("sales")
@Tag (name= "Sales resource")
public class SalesController {

    private final SalesServices salesServices;
    private final SalesMapper salesMapper;    

    public SalesController(SalesServices salesServices, SalesMapper salesMapper, JpaSalesRepository jpaSalesRepository) {
        this.salesServices = salesServices;
        this.salesMapper= salesMapper;
    }

    @Operation(summary = "Post in DB a sale given throught from body")
    @PostMapping("register")
    public Sales postMethodName(@Valid @RequestBody SalesDto entity) {
       return salesServices.createSales(salesMapper.fromDTOtoDomain(entity));    
    }    

    @Operation(summary = "Get all sales saved in the DB")
    @GetMapping("all")
    public List<Sales> findAllSales() {
        return salesServices.findSalesAll();
    } 
    
    @Operation(summary = "Get a sale by id saved in the DB")
    @GetMapping("/{id}")
    public Sales findById(@PathVariable Long id) {
        return salesServices.findSaleById(id);
    }

    @Operation(summary = "Delete a sale by id saved in the DB")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        salesServices.deleteSaleById(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Update a sale by id saved in the DB")
    @PutMapping("update/{id}")
    public ResponseEntity<Sales> update(@PathVariable Long id,  @RequestBody SalesUpdateDTO entity) {      
        Sales updated = salesServices.updateSales(id, salesMapper.fromUpdateDTOtoDomain(id, entity));
        return ResponseEntity.ok(updated);
    }
}