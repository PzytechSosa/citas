package com.test.citas.validaciones;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.repository.CitaRepository;
import com.test.citas.repository.ValidadorCitas;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsultorioHorario implements ValidadorCitas {

    @Autowired
    private CitaRepository citaRepository;

    public void validar(RegistrarCita registrarCita) {
        boolean existeCita = citaRepository.existsByConsultorioIdAndFechaCita(registrarCita.idConsultorio(),
                registrarCita.fechaCita());
        if (existeCita) {
            throw new ValidationException("No se puede agendar cita en un mismo consultorio a la misma hora");
        }
    }
}
