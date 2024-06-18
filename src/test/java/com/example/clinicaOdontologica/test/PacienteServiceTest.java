package com.example.clinicaOdontologica.test;

import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j //INSERTAR LOGGER
@SpringBootTest
class PacienteServiceTest {
  @Autowired
  private PacienteService pacienteService;
  private PacienteDtoReq paciente;

  @BeforeEach
  void setUp(){
   paciente = new PacienteDtoReq("Mariana",
           "González",
           "mariana.gonzalez@example.com",
           "33225544",
           "Calle Libertad",
           123,
           "Buenos Aires",
           "Argentina");

  }
  @Test
  @DisplayName("Testeo de creación del paciente")
  void createPaciente(){
    var pacienteSaved = this.pacienteService.create(paciente);
    log.info("id del nuevo paciente:"+pacienteSaved.id());
    assertNotNull(pacienteSaved);
  }
}