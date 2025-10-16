package com.actividad.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.actividad.app.model.Actividad;
import com.actividad.app.service.ActividadService;


@RestController
@RequestMapping("/api/actividades")
public class ActividadController {
    @Autowired
    private ActividadService service;

    @PostMapping
    public Actividad crear(@RequestBody Actividad a) {
        return service.crear(a);
    }

    @GetMapping
    public List<Actividad> listar() {
        return service.listarActivas();
    }

    @PutMapping("/{id}/estado/{estado}")
    public Actividad actualizar(@PathVariable Long id, @PathVariable String estado) {
        return service.cambiarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

