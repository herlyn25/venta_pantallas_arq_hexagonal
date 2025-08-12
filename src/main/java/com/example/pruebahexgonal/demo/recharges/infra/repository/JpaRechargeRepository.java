package com.example.pruebahexgonal.demo.recharges.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebahexgonal.demo.recharges.infra.persistence.RechargesEntity;

public interface JpaRechargeRepository extends JpaRepository<RechargesEntity, Long>{
    
}
