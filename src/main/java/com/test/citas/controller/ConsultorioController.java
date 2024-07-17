package com.test.citas.controller;

import com.test.citas.dto.RegistrarConsultorio;
import com.test.citas.entity.Consultorio;
import com.test.citas.service.ConsultorioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo consultorio en la base de datos")
    public ResponseEntity<Consultorio> add (@RequestBody @Valid RegistrarConsultorio registrarConsultorio){
        Consultorio consultorio = consultorioService.save(new Consultorio(registrarConsultorio));
        return ResponseEntity.ok(consultorio);
    }

}
