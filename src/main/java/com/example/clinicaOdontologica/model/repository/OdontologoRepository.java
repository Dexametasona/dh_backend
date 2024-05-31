package com.example.clinicaOdontologica.model.repository;

import com.example.clinicaOdontologica.model.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, UUID> {
}
