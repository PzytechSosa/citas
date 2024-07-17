package com.test.citas.utils;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class Errores {

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError404(MethodArgumentNotValidException e){
       var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
       return ResponseEntity.badRequest().body(errores);
   }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        String errorMessage = "El formato de la solicitud no es válido. Por favor, verifica los datos enviados.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity errorHandlerValidacionesDeNegocio(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Validacion.class)
    public ResponseEntity errorHandlerValidacion(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
