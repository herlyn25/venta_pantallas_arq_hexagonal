package com.example.pruebahexgonal.demo.application.exception;

public class CustomException extends RuntimeException {
    public CustomException(Long id) {
        super("El usuario con id " + id + " no existe");
    }

     public CustomException(String email) {
        super("El usuario con email " + email + " no existe");
    }
}