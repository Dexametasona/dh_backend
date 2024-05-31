package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.response.OdontologoDtoRes;

import java.util.List;
import java.util.UUID;

public interface OdontologoService {
  OdontologoDtoRes create(OdontologoDtoReq odontologoDto);
  OdontologoDtoRes getById(UUID id);
  OdontologoDtoRes updateById(OdontologoDtoReq odontologoDto, UUID id);
  void deleteById(UUID id);
  List<OdontologoDtoRes> getAll();

}
