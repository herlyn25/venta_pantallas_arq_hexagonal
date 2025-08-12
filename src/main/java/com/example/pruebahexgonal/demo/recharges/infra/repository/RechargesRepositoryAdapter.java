package com.example.pruebahexgonal.demo.recharges.infra.repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.recharges.domain.*;
import com.example.pruebahexgonal.demo.recharges.infra.persistence.*;

@Component
public class RechargesRepositoryAdapter implements RechargeRepositoryPort{

    private final JpaRechargeRepository jpaRechargeRepository;

    public RechargesRepositoryAdapter(JpaRechargeRepository jpaRechargeRepository) {
        this.jpaRechargeRepository = jpaRechargeRepository;
    }

    @Override
    public Recharges save(Recharges recharge) {
        RechargesEntity entity = new RechargesEntity();
        entity.setId(null);
        entity.setValueRecharge(recharge.getValueRecharge());
        entity.setDateRecharge((recharge.getDateRecharge()==null) ? LocalDate.now() : recharge.getDateRecharge());
        RechargesEntity rechargeSaved = jpaRechargeRepository.save(entity);
        return RechargesMapper.toDomain(rechargeSaved);
    }

    @Override
    public List<Recharges> findAll() {
        return jpaRechargeRepository.findAll().stream()
                    .map(RechargesMapper::toDomain).
                    collect(Collectors.toList());
    }

    @Override
    public Optional<Recharges> findById(Long id) {
        return jpaRechargeRepository.findById(id)
                .map(RechargesMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
       jpaRechargeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRechargeRepository.existsById(id);
    }
}