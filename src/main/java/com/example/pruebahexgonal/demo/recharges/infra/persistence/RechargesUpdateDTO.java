package com.example.pruebahexgonal.demo.recharges.infra.persistence;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RechargesUpdateDTO {

    private Integer valueRecharge;
    private LocalDate dateRecharge; 
}
