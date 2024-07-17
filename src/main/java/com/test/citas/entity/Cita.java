package com.test.citas.entity;

import com.test.citas.dto.RegistrarCita;
import com.test.citas.dto.RegistrarConsultorio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "consultorio_id", referencedColumnName = "id")
    private Consultorio consultorio;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
    private String nombrePaciente;
    private LocalDateTime fechaCita;

    public Cita(Consultorio consultorio, Doctor doctor, String nombrePaciente, LocalDateTime fechaCita) {
        this.consultorio = consultorio;
        this.doctor =  doctor;
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;
    }
}
