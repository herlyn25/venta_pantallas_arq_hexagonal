package com.example.pruebahexgonal.demo.sales.domain;

import java.time.LocalDate;
import com.example.pruebahexgonal.demo.clients.domain.Clients;

public class Sales {
    private Long id;
    private String description;
    private Integer valorCompra;
    private Integer valorVenta;    
    private Clients cliente;
    private LocalDate fechaCompra;
       
    public Sales() {
    }

    public Sales(String description, Integer valorCompra, Integer valorVenta, Integer ganancias, Clients cliente,
            LocalDate fechaCompra) {
        this.description = description;
        this.valorCompra = valorCompra;
        this.valorVenta = valorVenta;        
        this.cliente = cliente;
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
    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Integer getValorVenta() {
        return valorVenta;
    }
    public void setValorVenta(Integer valorVenta) {
        this.valorVenta = valorVenta;
    }
    
    public Clients getCliente() {
        return cliente;
    }
    public void setCliente(Clients cliente) {
        this.cliente = cliente;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {        
        this.fechaCompra = fechaCompra;
    }
}