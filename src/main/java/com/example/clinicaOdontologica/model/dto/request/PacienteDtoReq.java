package com.example.clinicaOdontologica.model.dto.request;


public record PacienteDtoReq(
        String nombre,
        String apellido,
        String email,
        String dni,
        String calle,
        int numero,
        String localidad,
        String provincia

) {
}
