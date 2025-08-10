package com.example.pruebahexgonal.demo.clients.infra.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data //Generar getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientsEntityUpdateDTO {   
    private String firstname;
    private String lastname;  
    private String email;    
}