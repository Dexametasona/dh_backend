package com.example.clinicaOdontologica.model.mapper;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.response.OdontologoDtoRes;
import com.example.clinicaOdontologica.model.entity.Odontologo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OdontologoMapper {
  Odontologo dtoReqToOdontologo(OdontologoDtoReq odontologoDto);
  OdontologoDtoRes odontologoToDtoRes(Odontologo odontologo);
  List<OdontologoDtoRes> listOdontologoToDtoRes(List<Odontologo> odontologos);
}
