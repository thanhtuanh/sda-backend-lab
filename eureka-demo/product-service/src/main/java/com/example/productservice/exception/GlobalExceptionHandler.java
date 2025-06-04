package com.example.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Globale Fehlerbehandlung für REST-Controller
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Fängt alle Exceptions ab
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        // Map für die Fehlermeldung vorbereiten
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getClass().getSimpleName()); // Typ der Exception
        error.put("message", ex.getMessage()); // Fehlernachricht

        // Gibt HTTP 500 mit JSON-Fehlermeldung zurück
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
