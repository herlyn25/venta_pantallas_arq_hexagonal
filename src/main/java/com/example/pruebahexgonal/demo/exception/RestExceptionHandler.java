package com.example.pruebahexgonal.demo.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Map<String,Object>> handleEmailInUse(EmailAlreadyUsedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of(
                "status", 409,
                "error", "Conflict",
                "message", ex.getMessage()
            ));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(CustomException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(                       
                        "status", 404,
                        "error", "Not Found",
                        "message", ex.getMessage()
                ));
    }
}
