package com.example.pruebahexgonal.demo.recharges.infra.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

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
        Recharges toCreate = RechargesMapper.fromDTOtoDomain(dto);
        Recharges saved = rechargesService.createRecharge(toCreate);
        return saved;
    }

    @GetMapping("all")
    public List<Recharges> findAll(){
        return rechargesService.findAllRecharges();
    }

    @GetMapping("/{id}")
    public Recharges findById(@PathVariable Long id){
        return rechargesService.findRechargesById(id);
    }

    

}
