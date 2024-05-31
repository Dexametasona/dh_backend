package com.example.clinicaOdontologica.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domicilio {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String calle;
  private int numero;
  private String localidad;
  private String provincia;

  @OneToOne(mappedBy = "domicilio", cascade = CascadeType.ALL)
  private Paciente paciente;

  @Override
  public String toString(){
    return String.format("%s, # %s, %s - %s",
            calle, numero, localidad, provincia);
  }
}
