package com.test.citas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RegistrarConsultorio(
        @NotNull
        @Min(1)
        Integer numeroConsultorio,
        @NotNull
        @Min(1)
        Integer piso
) {
}
