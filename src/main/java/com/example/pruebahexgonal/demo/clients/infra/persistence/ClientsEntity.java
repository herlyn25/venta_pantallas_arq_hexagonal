package com.example.pruebahexgonal.demo.clients.infra.persistence;

import java.util.List;

import com.example.pruebahexgonal.demo.sales.infra.persistence.SalesEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //Generar getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class ClientsEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String firstname;
    
    @Column(nullable = false)
    private String lastname;

    @Column(unique = true)
    private String email;  
    
    @JsonManagedReference //hace que este campo se obtenga como JSON 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<SalesEntity> sales;
}