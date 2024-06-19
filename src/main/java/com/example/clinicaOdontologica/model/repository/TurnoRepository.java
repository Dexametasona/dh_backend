package com.example.clinicaOdontologica.model.repository;

import com.example.clinicaOdontologica.model.dto.request.TurnoDTOreq;
import com.example.clinicaOdontologica.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    @Query("SELECT t FROM Turno t WHERE t.fechaCita BETWEEN :fechainicial AND :fechafinal")
    List<Turno> getTurnoBetweenFecha(@Param("fechainicial") LocalDateTime fechainicial, @Param("fechafinal") LocalDateTime fechafinal);


}
