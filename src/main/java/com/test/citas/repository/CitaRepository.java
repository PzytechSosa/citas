package com.test.citas.repository;

import com.test.citas.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    boolean existsByConsultorioIdAndFechaCita(Long doctorId, LocalDateTime fechaCita);
    boolean existsByDoctorIdAndFechaCita(Long doctorId, LocalDateTime fechaCita);
    boolean existsByNombrePacienteAndFechaCitaBetween(String nombre, LocalDateTime ahora, LocalDateTime horaDeConsulta);
    long countByDoctorIdAndFechaCitaBetween(Long aLong, LocalDateTime localDateTime, LocalDateTime localDateTime1);
    @Query("SELECT c FROM Cita c WHERE c.fechaCita BETWEEN :startOfDay AND :endOfDay")
    List<Cita> findByFechaCitaBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
    List<Cita> findByConsultorioId(Integer idConsultorio);
    @Query("SELECT c FROM Cita c WHERE c.doctor.nombre = :nombreDoctor AND c.fechaCita BETWEEN :startOfDay AND :endOfDay")
    List<Cita> findByDoctorNombreAndFechaCitaBetween(String nombreDoctor, LocalDateTime startOfDay, LocalDateTime endOfDay);
}
