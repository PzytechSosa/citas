package com.test.citas.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistrarCita(
        @NotNull
        @Min(1)
        Long idConsultorio,
        @NotNull
        @Min(1)
        Long idDoctor,
        @NotBlank
        String nombrePaciente,
        @NotNull
        @Future
        LocalDateTime fechaCita
) {
}
