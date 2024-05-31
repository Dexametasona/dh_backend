package com.example.clinicaOdontologica.model.dto.response;


import java.util.UUID;

public record OdontologoDtoRes(
        UUID id,
        String apellido,
        String nombre,
        String matricula
) {
}
