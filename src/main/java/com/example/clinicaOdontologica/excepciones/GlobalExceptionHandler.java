package com.example.clinicaOdontologica.excepciones;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(EntityNotFoundException.class )
    public ResponseEntity<?> atraparEntidadNoEncontrada(EntityNotFoundException e, WebRequest web)
    {
        ErrorDetalles errorDetalles= new ErrorDetalles(LocalDateTime.now(), e.getMessage(), web.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }
   @ExceptionHandler(ResourceNotFound.class )
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFound e, WebRequest web) {
        ErrorDetalles errorDetalles= new ErrorDetalles(LocalDateTime.now(), e.getMessage(), web.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class )
    public ResponseEntity<?> atraparExcepcion(Exception e, WebRequest web)
    {
        ErrorDetalles errorDetalles= new ErrorDetalles(LocalDateTime.now(), e.getMessage(), web.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }

}
