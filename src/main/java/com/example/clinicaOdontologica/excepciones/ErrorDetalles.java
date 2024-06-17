package com.example.clinicaOdontologica.excepciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetalles {
    private LocalDateTime fechaError;
    private String mensaje;
    private String detalles;

}
