package com.example.pruebahexgonal.demo.recharges.infra.persistence;

import org.springframework.stereotype.Component;

import com.example.pruebahexgonal.demo.recharges.domain.Recharges;

@Component
public class RechargesMapper {
    public static Recharges toDomain(RechargesEntity entity){
        if (entity == null) return null;
        Recharges recharges = new Recharges();
        recharges.setId(entity.getId());
        recharges.setValueRecharge(entity.getValueRecharge());
        recharges.setDateRecharge(entity.getDateRecharge());
        return recharges;
    }

    public static RechargesEntity toEntity(Recharges recharge){
        if (recharge == null) return null;
        RechargesEntity entity = new RechargesEntity();
        entity.setId(recharge.getId());
        entity.setValueRecharge(recharge.getValueRecharge());
        entity.setDateRecharge(recharge.getDateRecharge());
        return entity;
    }

     public static Recharges fromDTOtoDomain(RechargesDTO dto){
        if (dto == null) return null;
        Recharges recharges = new Recharges();        
        recharges.setValueRecharge(dto.getValueRecharge());
        return recharges;
    }
}
