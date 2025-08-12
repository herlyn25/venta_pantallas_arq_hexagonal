package com.example.pruebahexgonal.demo.recharges.application;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebahexgonal.demo.exception.CustomException;
import com.example.pruebahexgonal.demo.recharges.domain.*;



@Service
public class RechargesService {
    private final RechargeRepositoryPort rechargesPort;

    public RechargesService(RechargeRepositoryPort rechargesPort) {
        this.rechargesPort = rechargesPort;
    }

    @Transactional
    public Recharges createRecharge(Recharges recharges){       
        return rechargesPort.save(recharges);
    }

    @Transactional(readOnly = true)
    public List<Recharges> findAllRecharges(){
        return rechargesPort.findAll();
    }

    @Transactional(readOnly=true)
    public Recharges findRechargesById(Long id){
        return rechargesPort.findById(id).orElseThrow(
            () -> new CustomException(id, "Recharges")
        );
    }
    
    @Transactional
    public Recharges updateRecharge(Long id, Recharges incoming){
        Recharges current = findRechargesById(id);
        if (incoming.getDateRecharge() != null) current.setDateRecharge(incoming.getDateRecharge());
        if (incoming.getValueRecharge() !=null) current.setValueRecharge(incoming.getValueRecharge());
        
        return current;
    }

    @Transactional
    public void deleteRecharges(Long id){
        if (!rechargesPort.existsById(id))  throw new CustomException(id,"Recharges");
        rechargesPort.delete(id);
    }
}
