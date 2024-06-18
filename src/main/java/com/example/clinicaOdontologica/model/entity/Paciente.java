package com.example.clinicaOdontologica.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String apellido;
  private String nombre;
  private String email;
  private String dni;
  private LocalDateTime fechaIngreso;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "domicilio_id", referencedColumnName = "id", nullable = false)
  private Domicilio domicilio;

  @ManyToOne
  @JoinColumn(name = "odontologo_id")
  private Odontologo odontologo;

  @PrePersist
  public void onCreate(){
    this.fechaIngreso = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return String.format("%s %s, con dni: %s",
            nombre,apellido,dni);
  }
}
