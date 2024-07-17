package com.test.citas.service;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.entity.Cita;
import com.test.citas.entity.Consultorio;
import com.test.citas.entity.Doctor;
import com.test.citas.repository.CitaRepository;
import com.test.citas.repository.ConsultorioRepository;
import com.test.citas.repository.DoctorRepository;
import com.test.citas.repository.ValidadorCitas;
import com.test.citas.utils.Validacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @Autowired
    List<ValidadorCitas> validadores;

    @Transactional
    public Cita save(RegistrarCita registrarCita) {
        // Validar si el consultorio existe
        Consultorio consultorio = consultorioRepository.findById(registrarCita.idConsultorio())
                .orElseThrow(() -> new Validacion("Id para el consultorio no encontrado"));

        // Validar si el doctor existe
        Doctor doctor = doctorRepository.findById(registrarCita.idDoctor())
                .orElseThrow(() -> new Validacion("Id de doctor no encontrado"));

        validadores.forEach(v-> v.validar(registrarCita));

        var cita = new Cita(consultorio, doctor, registrarCita.nombrePaciente(), registrarCita.fechaCita());

        citaRepository.save(cita);

        return cita;
    }

    public List<Cita> consultarCitasPorFecha(LocalDate fechaCita) {
        LocalDateTime startOfDay = fechaCita.atStartOfDay();
        LocalDateTime endOfDay = fechaCita.atTime(LocalTime.MAX);
        return citaRepository.findByFechaCitaBetween(startOfDay, endOfDay);
    }

    public List<Cita> consultarCitasPorConsultorio(Integer idConsultorio) {
        return citaRepository.findByConsultorioId(idConsultorio);
    }

    public List<Cita> consultarCitasPorDoctorParaHoy(String nombreDoctor) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);
        return citaRepository.findByDoctorNombreAndFechaCitaBetween(nombreDoctor, startOfDay, endOfDay);
    }

    public List<Cita> consultarCitasPorDoctorParaManana(String nombreDoctor) {
        LocalDateTime startOfDay = LocalDate.now().plusDays(1).atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().plusDays(1).atTime(LocalTime.MAX);
        return citaRepository.findByDoctorNombreAndFechaCitaBetween(nombreDoctor, startOfDay, endOfDay);
    }
}
