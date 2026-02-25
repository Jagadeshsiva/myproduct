package com.example.product.globalexception;

import com.example.product.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleInvalidEnum(HttpMessageNotReadableException ex) {

        if (ex.getMessage().contains("Role")) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid role. Allowed values: " + Arrays.toString(Role.values()));
        }

        return ResponseEntity.badRequest().body("Invalid request format");
    }

}
