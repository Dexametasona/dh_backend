package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.model.dto.response.PacienteDtoRes;
import com.example.clinicaOdontologica.model.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PacienteService {
  PacienteDtoRes create(PacienteDtoReq pacienteDto);
  Page<PacienteDtoRes> getAll(Pageable pageable);
  PacienteDtoRes getById(UUID id);
  PacienteDtoRes updateById(PacienteDtoReq pacienteDto, UUID id);
  void deleteById(UUID id);
  List<PacienteDtoRes> getByApellido(String apellido);

}
