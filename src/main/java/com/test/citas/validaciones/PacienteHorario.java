package com.test.citas.validaciones;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.repository.CitaRepository;
import com.test.citas.repository.ValidadorCitas;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PacienteHorario implements ValidadorCitas {

    @Autowired
    private CitaRepository citaRepository;

    public void validar(RegistrarCita registrarCita) {
        var ahora = LocalDateTime.now();
        var horaDeConsulta= registrarCita.fechaCita();

        boolean existeCitaEnRango = citaRepository.existsByNombrePacienteAndFechaCitaBetween(
                registrarCita.nombrePaciente(), ahora, horaDeConsulta);
        if (existeCitaEnRango) {
            throw new ValidationException("No se puede agendar cita para un paciente a la misma hora o con menos de 2 horas de diferencia para el mismo día.");
        }
    }
}
