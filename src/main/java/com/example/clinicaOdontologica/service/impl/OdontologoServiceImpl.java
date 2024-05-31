package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.response.OdontologoDtoRes;
import com.example.clinicaOdontologica.model.mapper.OdontologoMapper;
import com.example.clinicaOdontologica.model.repository.OdontologoRepository;
import com.example.clinicaOdontologica.service.OdontologoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OdontologoServiceImpl implements OdontologoService {
  private final OdontologoRepository odontologoRepo;
  private final OdontologoMapper odontologoMap;

  @Override
  public OdontologoDtoRes create(OdontologoDtoReq odontologoDto) {
    var newOdontologo = this.odontologoRepo.save(odontologoMap.dtoReqToOdontologo(odontologoDto));
    return odontologoMap.odontologoToDtoRes(newOdontologo);
  }

  @Override
  public OdontologoDtoRes getById(UUID id) {
    var odontologo = this.odontologoRepo.findById(id).orElseThrow(
            ()->new EntityNotFoundException("Odontologo no encontrado, id: "+id));
    return this.odontologoMap.odontologoToDtoRes(odontologo);
  }

  @Override
  public OdontologoDtoRes updateById(OdontologoDtoReq odontologoDto, UUID id) {
    if(!this.odontologoRepo.existsById(id)){
      throw new EntityNotFoundException("Odontologo no encontrado, id: "+id);
    }
    var odontologo = this.odontologoMap.dtoReqToOdontologo(odontologoDto);
    odontologo.setId(id);
    var odontologoUpdated = this.odontologoRepo.save(odontologo);
    return this.odontologoMap.odontologoToDtoRes(odontologoUpdated);
  }

  @Override
  public void deleteById(UUID id) {
    if(!this.odontologoRepo.existsById(id)){
      throw new EntityNotFoundException("Odontologo no encontrado, id: "+id);
    }
    this.odontologoRepo.existsById(id);
  }

  @Override
  public List<OdontologoDtoRes> getAll() {
    var odontologos = this.odontologoRepo.findAll();
    return this.odontologoMap.listOdontologoToDtoRes(odontologos);
  }
}
