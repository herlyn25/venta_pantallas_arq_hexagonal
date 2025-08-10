package com.example.pruebahexgonal.demo.sales.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesEntity;

public interface JpaSalesRepository extends JpaRepository<SalesEntity,Long>{
    
}
