package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.request.TurnoDTOentreFechas;
import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.model.dto.response.TurnoDTOresp;
import com.example.clinicaOdontologica.service.TurnoService;
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
@RequestMapping("${api.basePath}/turno")
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TurnoDTOreq turnoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.turnoService.create(turnoDTO));
    }

    @PostMapping("/fechas")
    public ResponseEntity<?> obtenerTurnosEntreFechas(@RequestBody TurnoDTOentreFechas turnoDTOentreFechas)
{
    return ResponseEntity.ok(turnoService.listaDeTurnosPorFecha(turnoDTOentreFechas));
}
    @GetMapping
  public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "fechaCita") String sort,
                                  @RequestParam(defaultValue = "asc") String direction){
      Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sort));
      return ResponseEntity.ok(this.turnoService.getAll(pageable));
  }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(this.turnoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody TurnoDTOreq turnoDTO){
        return ResponseEntity.ok(this.turnoService.updateById(turnoDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        this.turnoService.deleteById(id);
        return ResponseEntity.ok("turno eliminado con éxito, id:"+id);
    }



}

