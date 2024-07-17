package com.test.citas.controller;

import com.test.citas.dto.RegistrarDoctor;
import com.test.citas.entity.Doctor;
import com.test.citas.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo medico en la base de datos")
    public ResponseEntity<Doctor> add (@RequestBody @Valid RegistrarDoctor registrarDoctor){
        Doctor doctor = doctorService.save(new Doctor(registrarDoctor));
        return ResponseEntity.ok(doctor);
    }
}
