package com.example.clinicaOdontologica.excepciones;


public class ResourceNotFound extends RuntimeException{
  public ResourceNotFound(String message) {
    super(message);
  }
}
