package com.example.clinicaOdontologica.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Odontologo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String apellido;
  private String nombre;
  private String matricula;
  @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Paciente> pacientes;

  @Override
  public String toString() {
    return String.format("%s %s, con matricula: %s",
            nombre, apellido, matricula);
  }
}
