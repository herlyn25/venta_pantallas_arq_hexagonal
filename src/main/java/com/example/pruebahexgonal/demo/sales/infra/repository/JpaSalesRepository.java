package com.example.pruebahexgonal.demo.sales.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesEntity;

public interface JpaSalesRepository extends JpaRepository<SalesEntity,Long>{
    List<SalesEntity> findByclient_Id(Long client_id);
}
