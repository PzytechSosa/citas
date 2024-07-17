package com.test.citas.controller;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.entity.Cita;
import com.test.citas.service.CitaService;
import com.test.citas.utils.Validacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo medico en la base de datos")
    public ResponseEntity<?> add (@RequestBody @Valid RegistrarCita registrarCita) throws Validacion {
        var response = citaService.save(registrarCita);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fechaCita")
    @Operation(summary = "Consulta cita por fecha.")
    public List<Cita> findByFechaCita(
            @Parameter(description = "Fecha de la cita en formato 'yyyy-MM-dd'", example = "2024-07-17")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCita) {
        return citaService.consultarCitasPorFecha(fechaCita);
    }

    @GetMapping("/consultorio")
    @Operation(summary = "Consulta cita por consultorio.")
    public List<Cita> findByConsultorio(@RequestParam Integer idConsultorio) {
        return citaService.consultarCitasPorConsultorio(idConsultorio);
    }

    @GetMapping("/citasPorDoctorHoy")
    @Operation(summary = "Consulta citas de un doctor para hoy.")
    public List<Cita> consultarCitasPorDoctorParaHoy(
            @RequestParam String nombreDoctor) {
        return citaService.consultarCitasPorDoctorParaHoy(nombreDoctor);
    }

    @GetMapping("/citasPorDoctorManana")
    @Operation(summary = "Consulta citas de un doctor para mañana.")
    public List<Cita> consultarCitasPorDoctorParaManana(
            @RequestParam String nombreDoctor) {
        return citaService.consultarCitasPorDoctorParaManana(nombreDoctor);
    }

}
