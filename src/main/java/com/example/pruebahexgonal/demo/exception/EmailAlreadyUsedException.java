package com.example.pruebahexgonal.demo.exception;

import java.text.MessageFormat;

public class EmailAlreadyUsedException extends RuntimeException {    
    public EmailAlreadyUsedException(String email) {
        super(MessageFormat.format("El email {0} ya está registrado", email));
    }
}
