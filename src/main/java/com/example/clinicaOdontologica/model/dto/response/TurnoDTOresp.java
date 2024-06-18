package com.example.clinicaOdontologica.model.dto.response;

import com.example.clinicaOdontologica.model.entity.Odontologo;

import java.time.LocalDate;

public record TurnoDTOresp(
        Integer id_turno,
        LocalDate fechaCita,
        String odontologo,
        String paciente
) {

}
