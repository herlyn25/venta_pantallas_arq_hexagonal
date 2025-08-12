package com.example.pruebahexgonal.demo.recharges.infra.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.representer.Represent;

import com.example.pruebahexgonal.demo.recharges.application.RechargesService;
import com.example.pruebahexgonal.demo.recharges.domain.Recharges;
import com.example.pruebahexgonal.demo.recharges.infra.persistence.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("recharges")
public class RechargesController {

    private final RechargesService rechargesService;

    public RechargesController(RechargesService rechargesService) {
        this.rechargesService = rechargesService;
    }   

    @PostMapping("register")
    public Recharges create(@Valid @RequestBody RechargesDTO dto){        
       return rechargesService.createRecharge(RechargesMapper.fromDTOtoDomain(dto));
         
    }

    @GetMapping("all")
    public List<Recharges> findAll(){
        return rechargesService.findAllRecharges();
    }

    @GetMapping("/{id}")
    public Recharges findById(@PathVariable Long id){
        return rechargesService.findRechargesById(id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,String>> deleteRecharges(@PathVariable Long id){
        rechargesService.deleteRecharges(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", String.format("usuario con id %s fue borrado satisfactoriamente", id));
        return ResponseEntity.ok(response);
    }
    @PutMapping("update/{id}")
    public Recharges updateRecharges(@PathVariable Long id , @RequestBody RechargesUpdateDTO dto){
        return rechargesService.updateRecharge(id, RechargesMapper.fromUpdateDTOtoDomain(id,dto));
    }
    

}
