package com.test.citas.validaciones;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.repository.CitaRepository;
import com.test.citas.repository.ValidadorCitas;
import com.test.citas.utils.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DoctorCitas implements ValidadorCitas {

    @Autowired
    private CitaRepository citaRepository;

    public void validar(RegistrarCita registrarCita) {
        LocalDate fechaCita = registrarCita.fechaCita().toLocalDate();
        long cantidadCitas = citaRepository.countByDoctorIdAndFechaCitaBetween(registrarCita.idDoctor(),
                fechaCita.atStartOfDay(), fechaCita.atTime(23, 59));
        if (cantidadCitas >= 8) {
            throw new Validacion("El doctor ya tiene 8 citas programadas para este día. No se puede agendar más citas.");
        }
    }

}
