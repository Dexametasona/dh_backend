package com.example.clinicaOdontologica.model.dto.request;

import com.example.clinicaOdontologica.model.entity.Odontologo;
import com.example.clinicaOdontologica.model.entity.Paciente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TurnoDTOreq(
        LocalDateTime fechaCita,
        UUID id_paciente,
        UUID id_odontologo) {


}
