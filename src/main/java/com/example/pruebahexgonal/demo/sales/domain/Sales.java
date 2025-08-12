package com.example.pruebahexgonal.demo.sales.domain;

import java.time.LocalDate;

public class Sales {
    private Long id;
    private String description;
    private Integer valorCompra;
    private Integer valorVenta;    
    private Long clientId;
    private LocalDate fechaCompra;
       
    public Sales() {
    }

    public Sales(Long id,String description, Integer valorCompra, Integer valorVenta, Long clientId,
            LocalDate fechaCompra) {
        this.id = id;
        this.description = description;
        this.valorCompra = valorCompra;
        this.valorVenta = valorVenta;        
        this.clientId = clientId;
        this.fechaCompra = fechaCompra;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(Integer valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Integer getValorVenta() {
        return valorVenta;
    }
    public void setValorVenta(Integer valorVenta) {
        this.valorVenta = valorVenta;
    }
    
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {        
        this.fechaCompra = fechaCompra;
    }
}