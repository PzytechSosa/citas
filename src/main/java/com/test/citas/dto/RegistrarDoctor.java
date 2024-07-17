package com.test.citas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarDoctor(
        @NotBlank
        String nombre,
        @NotBlank
        String apellidoPaterno,
        @NotBlank
        String apellidoMaterno,
        @NotNull
        String especialidad
) {
}
