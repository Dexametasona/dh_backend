package com.example.clinicaOdontologica.test;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import com.example.clinicaOdontologica.service.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {
  @Autowired
  private OdontologoService odontologoService;
  @Autowired
  private PacienteService pacienteService;
  @Autowired
  private TurnoService turnoService;

  private TurnoDTOreq newTurno;
  private UUID id_paciente;
  private UUID id_odontologo;


  @BeforeEach
  void setUp() {
    var paciente = new PacienteDtoReq("Mariana",
            "González",
            "mariana.gonzalez@example.com",
            "33225544",
            "Calle Libertad",
            123,
            "Buenos Aires",
            "Argentina");
    var odontologo = new OdontologoDtoReq("perez",
            "roberto",
            "12345");
    var pacienteSaved = this.pacienteService.create(paciente);
    var odontologoSaved = this.odontologoService.create(odontologo);

    id_paciente = pacienteSaved.id();
    id_odontologo = odontologoSaved.id();
  }

  @Test
  @DisplayName("Creando un turno ")
  void createTurno() {
    var newTurno = new TurnoDTOreq(LocalDateTime.now(), id_paciente, id_odontologo);
    var turnoSaved = this.turnoService.create(newTurno);
    assertNotNull(turnoSaved);
  }
}