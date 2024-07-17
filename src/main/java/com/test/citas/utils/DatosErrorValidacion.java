package com.test.citas.utils;

import org.springframework.validation.FieldError;

public record DatosErrorValidacion(String campo, String error) {

    public DatosErrorValidacion(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
