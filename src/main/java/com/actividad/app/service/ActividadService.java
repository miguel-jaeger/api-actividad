package com.actividad.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad.app.model.Actividad;
import com.actividad.app.repository.ActividadRepository;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository repo;

    public Actividad crear(Actividad a) {
        return repo.save(a);
    }

    public List<Actividad> listarActivas() {
        return repo.findByActivoTrue();
    }

    public Actividad cambiarEstado(Long id, String nuevoEstado) {
        Actividad act = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrada"));
        act.setEstado(nuevoEstado);
        return repo.save(act);
    }

    public void eliminar(Long id) {
        Actividad act = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrada"));
        act.setActivo(false);
        repo.save(act);
    }


}
