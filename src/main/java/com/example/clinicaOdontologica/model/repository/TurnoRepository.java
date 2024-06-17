package com.example.clinicaOdontologica.model.repository;

import com.example.clinicaOdontologica.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
