package com.example.clinicaOdontologica.model.dto.response;

import com.example.clinicaOdontologica.model.entity.Odontologo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TurnoDTOresp(
        Integer id_turno,
        LocalDateTime fechaCita,
        String odontologo,
        String paciente
) {

}
