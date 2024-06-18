package com.example.clinicaOdontologica.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record PacienteDtoRes(
        UUID id,
        String nombre,
        String apellido,
        String email,
        String dni,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
        LocalDateTime fechaIngreso,
        String odontologo,
        String domicilio
) {
}
