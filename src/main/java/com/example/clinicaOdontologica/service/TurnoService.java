package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.dto.request.TurnoDTOentreFechas;
import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.model.dto.response.TurnoDTOresp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TurnoService {
    TurnoDTOresp create(TurnoDTOreq turno );
    Page<TurnoDTOresp> getAll(Pageable pageable);
    TurnoDTOresp getById(int id);
    TurnoDTOresp updateById(TurnoDTOreq turnoDTO, int id);
    void deleteById(int id);

    List<TurnoDTOresp> listaDeTurnosPorFecha (TurnoDTOentreFechas turnoDTOentreFechas);


}
