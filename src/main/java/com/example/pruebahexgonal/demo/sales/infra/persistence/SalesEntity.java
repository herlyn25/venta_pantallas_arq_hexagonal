package com.example.pruebahexgonal.demo.sales.infra.persistence;

import java.time.LocalDate;
import com.example.pruebahexgonal.demo.clients.infra.persistence.ClientsEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sales")
public class SalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String description;
    private Integer valorCompra;
    private Integer valorVenta;
    private LocalDate fechaCompra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable = false)
    private ClientsEntity client;    
}