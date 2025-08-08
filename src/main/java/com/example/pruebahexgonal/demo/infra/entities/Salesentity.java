package com.example.pruebahexgonal.demo.infra.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sales")
public class Salesentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int valorCompra;
    private int valorVenta;
    private int ganancias;
    private Date fechaCompra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private ClientsEntity client;
    
}
