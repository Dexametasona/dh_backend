package com.example.clinicaOdontologica.model.repository;

import com.example.clinicaOdontologica.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    List<Paciente> getAllByApellido(String apellido);
}
