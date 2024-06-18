package com.example.clinicaOdontologica.model.mapper;

import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.model.dto.response.TurnoDTOresp;
import com.example.clinicaOdontologica.model.entity.Odontologo;
import com.example.clinicaOdontologica.model.entity.Paciente;
import com.example.clinicaOdontologica.model.entity.Turno;
import com.example.clinicaOdontologica.model.repository.OdontologoRepository;
import com.example.clinicaOdontologica.model.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TurnoMapper {

  @Mapping(target = "odontologo", source = "id_odontologo")
  @Mapping(target = "paciente", source = "id_paciente")
  Turno DTOreqToTurno(TurnoDTOreq dtoreq,
                      @Context OdontologoRepository odontologoRepository,
                      @Context PacienteRepository pacienteRepository);

  @Mapping(target = "id_turno", source = "ID")
  @Mapping(target = "odontologo", expression = "java(turno.getOdontologo().toString())")
  @Mapping(target = "paciente", expression = "java(turno.getPaciente().toString())")
  TurnoDTOresp TurnoToDTOresp(Turno turno);

  default Odontologo map(UUID id_odontologo, @Context OdontologoRepository odontologoRepository) {
    return odontologoRepository
            .findById(id_odontologo)
            .orElseThrow(() -> new EntityNotFoundException("No encontrado odontologo"));
  }

  default Paciente map(UUID id_paciente, @Context PacienteRepository pacienteRepository) {
    return pacienteRepository
            .findById(id_paciente)
            .orElseThrow(() -> new EntityNotFoundException("No se encontro paciente"));
  }
}
