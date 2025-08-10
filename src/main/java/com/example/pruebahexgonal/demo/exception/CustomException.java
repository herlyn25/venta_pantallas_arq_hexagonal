package com.example.pruebahexgonal.demo.exception;

public class CustomException extends RuntimeException {
    public CustomException(Long id, String entity) {
        super(String.format("%s con id %s no existe", entity , id));
    }

    public CustomException(String email) {
        super("El usuario con email " + email + " no existe");
    }

    
}