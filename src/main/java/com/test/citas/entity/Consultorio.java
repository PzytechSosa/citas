package com.test.citas.entity;

import com.test.citas.dto.RegistrarConsultorio;
import com.test.citas.dto.RegistrarDoctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Consultorio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroConsultorio;
    private Integer piso;

    public Consultorio(RegistrarConsultorio registrarConsultorio) {
        this.numeroConsultorio = registrarConsultorio.numeroConsultorio();
        this.piso = registrarConsultorio.piso();
    }

}
