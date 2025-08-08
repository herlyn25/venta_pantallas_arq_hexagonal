package com.example.pruebahexgonal.demo.infra.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data //Generar getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClientsEntityDTO {   
    @NotBlank 
    private String firstname;

    @NotBlank 
    private String lastname;  
    
    @Email @NotBlank 
    private String email;    
}