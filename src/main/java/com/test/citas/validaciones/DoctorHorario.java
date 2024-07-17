package com.test.citas.validaciones;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.repository.CitaRepository;
import com.test.citas.repository.ValidadorCitas;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorHorario implements ValidadorCitas {

    @Autowired
    private CitaRepository citaRepository;

    public void validar(RegistrarCita registrarCita) {
        boolean existeCita = citaRepository.existsByDoctorIdAndFechaCita(registrarCita.idDoctor(),
                registrarCita.fechaCita());
        if (existeCita) {
            throw new ValidationException("No se puede agendar cita con un mismo doctor a la misma hora");
        }
    }
}
