package com.example.pruebahexgonal.demo.recharges.infra.persistence;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recharge")

public class RechargesEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer valueRecharge;
    private LocalDate dateRecharge;
}
