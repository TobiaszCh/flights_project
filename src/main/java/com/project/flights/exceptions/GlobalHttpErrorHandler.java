package com.project.flights.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AllNotFoundException.class)
    public ResponseEntity<Object> handleCarrierNotFoundException() {
        return ResponseEntity.badRequest().body("Not Exist");
    }
}
