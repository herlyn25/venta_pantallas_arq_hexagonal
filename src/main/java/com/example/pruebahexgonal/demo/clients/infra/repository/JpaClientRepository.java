package com.example.pruebahexgonal.demo.clients.infra.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;

import java.util.*;

public interface JpaClientRepository extends JpaRepository<ClientsEntity,Long>{
    boolean existsByEmail(String email);
    Optional<ClientsEntity> findByEmail(String email);
 }