package com.example.clinicaOdontologica.model.mapper;

import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.model.dto.response.PacienteDtoRes;
import com.example.clinicaOdontologica.model.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
  @Mapping(target = "domicilio.calle", source = "calle")
  @Mapping(target = "domicilio.numero", source = "numero")
  @Mapping(target = "domicilio.localidad", source = "localidad")
  @Mapping(target = "domicilio.provincia", source = "provincia")
  Paciente dtoReqToPaciente(PacienteDtoReq pacienteDtoReq);

  @Mapping(target = "domicilio", expression = "java(paciente.getDomicilio().toString())")
  @Mapping(target = "odontologo", expression = "java(paciente.getOdontologo() != null ? paciente.getOdontologo().toString() : \"no hay odontologo asociado\")")
  @Mapping(target = "fechaIngreso", dateFormat = "dd-MM-yyyy HH:mm")
  PacienteDtoRes pacienteToDtoRes(Paciente paciente);

  List<PacienteDtoRes> listPacienteToDto(List<Paciente> pacientes);
}
