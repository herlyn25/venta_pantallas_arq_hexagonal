package com.example.pruebahexgonal.demo.recharges.infra.persistence;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RechargesDTO {
    @NotNull(message = "Recharge value is required")
    private Integer valueRecharge;
}
