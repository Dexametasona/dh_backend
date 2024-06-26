package com.example.clinicaOdontologica.service.impl;


import com.example.clinicaOdontologica.model.dto.request.TurnoDTOentreFechas;

import com.example.clinicaOdontologica.excepciones.ResourceNotFound;

import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.model.dto.response.TurnoDTOresp;
import com.example.clinicaOdontologica.model.entity.Turno;
import com.example.clinicaOdontologica.model.mapper.TurnoMapper;
import com.example.clinicaOdontologica.model.repository.OdontologoRepository;
import com.example.clinicaOdontologica.model.repository.PacienteRepository;
import com.example.clinicaOdontologica.model.repository.TurnoRepository;
import com.example.clinicaOdontologica.service.TurnoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor//solo atributos final
@Service
@Slf4j
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private final TurnoMapper mapperTurno;
    private final OdontologoRepository odontologoRepository;
    private final PacienteRepository pacienteRepository;
    @Override
    public TurnoDTOresp create(TurnoDTOreq turno) {
        if(!this.odontologoRepository.existsById(turno.id_odontologo())){
            throw new ResourceNotFound("Id de odontologo no valido.");
        }

        Turno entidadTurno=mapperTurno.DTOreqToTurno(turno,odontologoRepository,pacienteRepository);
        Turno turnoGuardado = turnoRepository.save(entidadTurno);

        log.info("Turno persistido "+turnoGuardado);

        return mapperTurno.TurnoToDTOresp(turnoGuardado);
    }

    @Override
    public Page<TurnoDTOresp> getAll(Pageable pageable) {
        var turnos = this.turnoRepository.findAll(pageable);
        log.info("Turnos listados ");
        var turnosDTO = turnos.getContent()
                .stream()
                .map(mapperTurno::TurnoToDTOresp)
                .toList();
        return new PageImpl<>(turnosDTO, pageable, turnos.getTotalElements());
    }

    @Override
    public TurnoDTOresp getById(int id) {
        var turnoFound = this.turnoRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("No se encontró al turno con id: "+id));
        log.info("Turno encontrado por ID "+turnoFound);
        return mapperTurno.TurnoToDTOresp(turnoFound);
    }

    @Override
    public TurnoDTOresp updateById(TurnoDTOreq turnoDTO, int id) {
        if(!this.turnoRepository.existsById(id)){
            throw new EntityNotFoundException("Turno no encontrado, id:"+ id);
        }
        var newTurno = this.mapperTurno.DTOreqToTurno(turnoDTO,odontologoRepository,pacienteRepository);
        newTurno.setID(id);
        log.info("Turno actualizado por ID "+newTurno);
        return this.mapperTurno.TurnoToDTOresp(this.turnoRepository.save(newTurno));
    }

    @Override
    public void deleteById(int id) {
        var turno=this.turnoRepository.existsById(id);
        if(!turno){
            throw new EntityNotFoundException("Turno no encontrado, id:"+ id);
        }
        this.turnoRepository.deleteById(id);
        log.info("Turno eliminado por ID "+turno);
    }

    @Override
    public List<TurnoDTOresp> listaDeTurnosPorFecha(TurnoDTOentreFechas turnoDTOentreFechas) {
        List<Turno> turnosresp = turnoRepository.getTurnoBetweenFecha(turnoDTOentreFechas.fechainicio(),turnoDTOentreFechas.fechafinal());

        return turnosresp.stream().map(mapperTurno::TurnoToDTOresp).toList();
    }
}



