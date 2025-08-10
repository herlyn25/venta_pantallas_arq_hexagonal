package com.example.pruebahexgonal.demo.clients.infra.persistence;

import jakarta.validation.constraints.*;
import lombok.*;

@Data //Generar getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClientsEntityDTO {   
    @NotBlank(message = "Firstname  is required") 
    private String firstname;

    @NotBlank(message = "Lastname  is required")  
    private String lastname;  
    
    @Email(message = "Formato invalido") 
    @NotBlank(message = "Email  is required")  
    private String email;    
}