package com.example.pruebahexgonal.demo.domain.pojo;

import java.util.Date;

public class Sales {
    private Long id;
    private String description;
    private int valorCompra;
    private int valorVenta;
    private int ganancias;
    private Clients cliente;
    private Date fechaCompra;
    
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
    public int getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }
    public int getValorVenta() {
        return valorVenta;
    }
    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }
    public int getGanancias() {
        return ganancias;
    }
    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }
    public Clients getCliente() {
        return cliente;
    }
    public void setCliente(Clients cliente) {
        this.cliente = cliente;
    }
    public Date getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(Date fechaCompra) {
        fechaCompra = new Date();
        this.fechaCompra = fechaCompra;
    }
}