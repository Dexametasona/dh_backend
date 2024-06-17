package com.example.clinicaOdontologica.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(nullable = false)
    private LocalDateTime fechaCita;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Odontologo odontologo;



}
