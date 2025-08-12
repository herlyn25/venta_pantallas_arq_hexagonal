package com.example.pruebahexgonal.demo.sales.infra.persistence;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data //Generar getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesUpdateDTO{
   private String description;
   private Integer valorCompra;
   private Integer valorVenta;  
   private LocalDate fechaCompra;     // formato ISO "2025-08-09"
   private Long clientId;
   }