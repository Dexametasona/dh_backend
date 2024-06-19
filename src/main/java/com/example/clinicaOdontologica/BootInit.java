package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BootInit implements ApplicationRunner {
  private final PacienteService pacienteService;
  private final OdontologoService odontologoService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("-------------------Insertando pacientes-------------------------");

    List<PacienteDtoReq> dummyPacientes = List.of(
            new PacienteDtoReq("Juan", "Pérez", "juan.perez@example.com", "12345678", "Calle Falsa", 123, "Buenos Aires", "Buenos Aires"),
            new PacienteDtoReq("María", "Gomez", "maria.gonzalez@example.com", "87654321", "Avenida Siempre Viva", 456, "Rosario", "Santa Fe"),
            new PacienteDtoReq("Carlos", "Rodríguez", "carlos.rodriguez@example.com", "11223344", "Boulevard Central", 789, "Córdoba", "Córdoba"),
            new PacienteDtoReq("Ana", "López", "ana.lopez@example.com", "44332211", "Calle Principal", 101, "Mendoza", "Mendoza"),
            new PacienteDtoReq("Luis", "Martínez", "luis.martinez@example.com", "55667788", "Avenida Libertador", 202, "San Miguel de Tucumán", "Tucumán"),
            new PacienteDtoReq("Laura", "Fernández", "laura.fernandez@example.com", "99887766", "Calle Secundaria", 303, "Salta", "Salta"),
            new PacienteDtoReq("Jorge", "Gomez", "jorge.gomez@example.com", "66554433", "Pasaje los Andes", 404, "Santa Rosa", "La Pampa"),
            new PacienteDtoReq("Sofía", "Hernández", "sofia.hernandez@example.com", "33445566", "Calle Independencia", 505, "Neuquén", "Neuquén"),
            new PacienteDtoReq("Miguel", "Torres", "miguel.torres@example.com", "22114433", "Avenida de Mayo", 606, "San Juan", "San Juan"),
            new PacienteDtoReq("Lucía", "Ramírez", "lucia.ramirez@example.com", "77889900", "Calle Belgrano", 707, "Posadas", "Misiones")
    );
    for(var paciente:dummyPacientes){
      this.pacienteService.create(paciente);
    }
    log.info("-------------------Insertando odontologos-------------------------");
    List<OdontologoDtoReq> dummyOdontologos = List.of(
            new OdontologoDtoReq("González", "Carlos", "MAT1234"),
            new OdontologoDtoReq("Pérez", "Laura", "MAT5678"),
            new OdontologoDtoReq("Rodríguez", "Sofía", "MAT9101"),
            new OdontologoDtoReq("Martínez", "Juan", "MAT1121")
    );
    for(var odontologo:dummyOdontologos){
      this.odontologoService.create(odontologo);
    }

  }
}
