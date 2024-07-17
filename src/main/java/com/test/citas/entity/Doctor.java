package com.test.citas.entity;

import com.test.citas.dto.RegistrarDoctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String especialidad;

    public Doctor(RegistrarDoctor registrarDoctor) {
        this.nombre = registrarDoctor.nombre();
        this.aPaterno = registrarDoctor.apellidoPaterno();
        this.aMaterno = registrarDoctor.apellidoMaterno();
        this.especialidad = registrarDoctor.especialidad();
    }
}
