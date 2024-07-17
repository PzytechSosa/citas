package com.test.citas.service;

import com.test.citas.entity.Consultorio;
import com.test.citas.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    public Consultorio save(Consultorio registrarConsultorio) {
        return this.consultorioRepository.save(registrarConsultorio);
    }
}
