package com.example.pruebahexgonal.demo.sales.infra.persistence;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record SalesDto(
    @NotBlank(message = "Descripcion es requerida") String description,
    @NotNull(message = "valor de compra es requerido") Integer valorCompra,
    @NotNull(message = "valor de venta es requerido") Integer valorVenta,   
    LocalDate fechaCompra,     // formato ISO "2025-08-09"
    @NotNull(message = "Client id es requerido")
    @Positive(message = "Valor debe ser mayor a 0")
    Long clientId
) {}
