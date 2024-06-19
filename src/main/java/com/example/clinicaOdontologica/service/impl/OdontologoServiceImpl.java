package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.response.OdontologoDtoRes;
import com.example.clinicaOdontologica.model.entity.Odontologo;
import com.example.clinicaOdontologica.model.mapper.OdontologoMapper;
import com.example.clinicaOdontologica.model.repository.OdontologoRepository;
import com.example.clinicaOdontologica.service.OdontologoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class OdontologoServiceImpl implements OdontologoService {
  private final OdontologoRepository odontologoRepo;
  private final OdontologoMapper odontologoMap;

  @Override
  public OdontologoDtoRes create(OdontologoDtoReq odontologoDto) {
    Odontologo odontologo= odontologoMap.dtoReqToOdontologo(odontologoDto);
    var newOdontologo = this.odontologoRepo.save(odontologo);
    log.info("Odontologo persistido "+odontologo);
    return odontologoMap.odontologoToDtoRes(newOdontologo);
  }

  @Override
  public OdontologoDtoRes getById(UUID id) {
    var odontologo = this.odontologoRepo.findById(id).orElseThrow(
            ()->new EntityNotFoundException("Odontologo no encontrado, id: "+id));
    log.info("Odontologo encontrado por ID "+odontologo);
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
    log.info("Odontologo actualizado por ID "+odontologo);
    return this.odontologoMap.odontologoToDtoRes(odontologoUpdated);
  }

  @Override
  public void deleteById(UUID id) {
    var odontologo =this.odontologoRepo.existsById(id);
    if(!odontologo){
      throw new EntityNotFoundException("Odontologo no encontrado, id: "+id);
    }
    this.odontologoRepo.deleteById(id);
    log.info("Odontologo borrado por ID ",odontologo);
  }

  @Override
  public List<OdontologoDtoRes> getAll() {
    var odontologos = this.odontologoRepo.findAll();
    log.info("Lista de odontologos");
    return this.odontologoMap.listOdontologoToDtoRes(odontologos);
  }
}
