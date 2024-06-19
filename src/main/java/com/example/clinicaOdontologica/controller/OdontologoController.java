package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.service.OdontologoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.basePath}/odontologo")
@RequiredArgsConstructor

public class OdontologoController {
  private final OdontologoService odontologoService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody OdontologoDtoReq odontologoDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.odontologoService.create(odontologoDto));
  }

  @GetMapping
  public ResponseEntity<?> getAll(){
    return ResponseEntity.ok(this.odontologoService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable UUID id){
    return ResponseEntity.ok(this.odontologoService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateById(@PathVariable UUID id, @RequestBody OdontologoDtoReq odontologoDto){
    return ResponseEntity.ok(this.odontologoService.updateById(odontologoDto, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable UUID id){
    this.odontologoService.deleteById(id);
    return ResponseEntity.ok("odontologo eliminado con éxito, id:"+id);
  }
}
