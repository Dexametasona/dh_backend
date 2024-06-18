package com.example.clinicaOdontologica.model.dto.request;

import com.example.clinicaOdontologica.model.entity.Odontologo;
import com.example.clinicaOdontologica.model.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TurnoDTOreq(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime fechaCita,
        UUID id_paciente,
        UUID id_odontologo) {


}
