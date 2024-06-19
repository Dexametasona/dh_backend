package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basePath}/paciente")
public class PacienteController {
  private final PacienteService pacienteService;

  @GetMapping
  public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "fechaIngreso") String sort,
                                  @RequestParam(defaultValue = "asc") String direction){
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sort));
    return ResponseEntity.ok(this.pacienteService.getAll(pageable));
  }
  @PostMapping
  public ResponseEntity<?> create(@RequestBody PacienteDtoReq pacienteDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.pacienteService.create(pacienteDto));
  }


  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable UUID id){
    return ResponseEntity.ok(this.pacienteService.getById(id));
  }

  @GetMapping("/apellido/{apellido}")
  public ResponseEntity<?> getAllByApellido(@PathVariable String apellido){
    return ResponseEntity.ok(this.pacienteService.getByApellido(apellido));
  }
  @PutMapping("/{id}")
  public ResponseEntity<?> updateById(@PathVariable UUID id, @RequestBody PacienteDtoReq pacienteDto){
    return ResponseEntity.ok(this.pacienteService.updateById(pacienteDto, id));
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable UUID id){
    this.pacienteService.deleteById(id);
    return ResponseEntity.ok("Paciente con id: "+id+" eliminado con éxito.");
  }
}
