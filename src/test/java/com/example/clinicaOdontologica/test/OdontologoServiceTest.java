package com.example.clinicaOdontologica.test;

import com.example.clinicaOdontologica.model.dto.request.OdontologoDtoReq;
import com.example.clinicaOdontologica.model.dto.request.PacienteDtoReq;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j //INSERTAR LOGGER
@SpringBootTest
class OdontologoServiceTest {

        @Autowired
        private OdontologoService odontologoService;
        private OdontologoDtoReq odontologo;

        @BeforeEach
        void setUp(){
            odontologo = new OdontologoDtoReq("Mariana",
                    "González",

                    "33225544"

                 );

        }
        @Test
        @DisplayName("Testeo de creación del odontologo")
        void createOdontologo(){
            var odontologoSaved = this.odontologoService.create(odontologo);
            log.info("id del nuevo odontologo:"+odontologoSaved.id());
            assertNotNull(odontologoSaved);
        }

}