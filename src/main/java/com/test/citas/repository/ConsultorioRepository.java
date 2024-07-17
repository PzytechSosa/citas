package com.test.citas.repository;

import com.test.citas.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    Consultorio findByNumeroConsultorio(Integer integer);
}
