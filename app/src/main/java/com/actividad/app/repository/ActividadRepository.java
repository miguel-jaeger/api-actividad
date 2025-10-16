package com.actividad.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actividad.app.model.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    List<Actividad> findByEstadoAndActivoTrue(String estado);
    List<Actividad> findByActivoTrue();
}
