package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.model.dto.response.PacienteDtoRes;
import com.example.clinicaOdontologica.model.mapper.PacienteMapper;
import com.example.clinicaOdontologica.model.repository.PacienteRepository;
import com.example.clinicaOdontologica.service.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PacienteServiceImpl implements PacienteService {
  private final PacienteRepository pacienteRepo;
  private final PacienteMapper pacienteMap;

  @Override
  @Transactional
  public PacienteDtoRes create(PacienteDtoReq pacienteDto) {

    var newPaciente = pacienteMap.dtoReqToPaciente(pacienteDto);
    var pacienteSaved = this.pacienteRepo.save(newPaciente);

    return pacienteMap.pacienteToDtoRes(pacienteSaved);
  }

  @Override
  public Page<PacienteDtoRes> getAll(Pageable pageable) {
    var pacientes = this.pacienteRepo.findAll(pageable);
    var pacientesDto = pacientes.getContent()
            .stream()
            .map(pacienteMap::pacienteToDtoRes)
            .toList();
    return new PageImpl<>(pacientesDto, pageable, pacientes.getTotalElements());
  }

  @Override
  public PacienteDtoRes getById(UUID id) {
    var pacienteFounded = this.pacienteRepo.findById(id).orElseThrow(
            ()->new EntityNotFoundException("No se encontró al paciente con id: "+id));
    return pacienteMap.pacienteToDtoRes(pacienteFounded);
  }

  @Override
  public PacienteDtoRes updateById(PacienteDtoReq pacienteDto, UUID id) {
    if(!this.pacienteRepo.existsById(id)){
      throw new EntityNotFoundException("Paciente no encontrado, id:"+ id);
    }
    var newPaciente = this.pacienteMap.dtoReqToPaciente(pacienteDto);
    newPaciente.setId(id);
    return this.pacienteMap.pacienteToDtoRes(this.pacienteRepo.save(newPaciente));
  }

  @Override
  public void deleteById(UUID id) {
    if(!this.pacienteRepo.existsById(id)){
      throw new EntityNotFoundException("Paciente no encontrado, id:"+ id);
    }
    this.pacienteRepo.deleteById(id);
  }
}
