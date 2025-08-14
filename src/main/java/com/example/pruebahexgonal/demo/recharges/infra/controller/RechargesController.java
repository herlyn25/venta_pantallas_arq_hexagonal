package com.example.pruebahexgonal.demo.recharges.infra.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pruebahexgonal.demo.recharges.application.RechargesService;
import com.example.pruebahexgonal.demo.recharges.domain.Recharges;
import com.example.pruebahexgonal.demo.recharges.infra.persistence.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("recharges")
@Tag (name= "Recharge resource")
public class RechargesController {

    private final RechargesService rechargesService;
      
    public RechargesController(RechargesService rechargesService) {
        this.rechargesService = rechargesService;
    }
    
    @Operation(summary = "Post in DB a Recharges given throught from body")
    @PostMapping("register")
    public Recharges create(@Valid @RequestBody RechargesDTO dto){        
       return rechargesService.createRecharge(RechargesMapper.fromDTOtoDomain(dto));         
    }

    @Operation(summary = "Get all recharges saved in the DB")
    @GetMapping("all")
    public List<Recharges> findAll(){
        return rechargesService.findAllRecharges();
    }

    @Operation(summary = "Get a recharges by id saved in the DB")
    @GetMapping("/{id}")
    public Recharges findById(@PathVariable Long id){
        return rechargesService.findRechargesById(id);
    }

    @Operation(summary = "Delete a recharge by id saved in the DB")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,String>> deleteRecharges(@PathVariable Long id){
        rechargesService.deleteRecharges(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", String.format("usuario con id %s fue borrado satisfactoriamente", id));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update a recharge by id saved in the DB")
    @PutMapping("update/{id}")
    public Recharges updateRecharges(@PathVariable Long id , @RequestBody RechargesUpdateDTO dto){
        return rechargesService.updateRecharge(id, RechargesMapper.fromUpdateDTOtoDomain(id,dto));
    }
}