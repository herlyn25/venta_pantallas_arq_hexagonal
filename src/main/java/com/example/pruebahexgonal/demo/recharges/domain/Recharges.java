package com.example.pruebahexgonal.demo.recharges.domain;

import java.time.LocalDate;

public class Recharges {
    private Long id;
    private Integer valueRecharge;
    private LocalDate dateRecharge;

    public Recharges(){}
    
    public Recharges(Long id, Integer valueRecharge, LocalDate dateRecharge) {
        this.id = id;
        this.valueRecharge = valueRecharge;
        this.dateRecharge = dateRecharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValueRecharge() {
        return valueRecharge;
    }

    public void setValueRecharge(Integer valueRecharge) {
        this.valueRecharge = valueRecharge;
    }

    public LocalDate getDateRecharge() {
        return dateRecharge;
    }

    public void setDateRecharge(LocalDate dateRecharge) {
        this.dateRecharge = dateRecharge;
    }
}