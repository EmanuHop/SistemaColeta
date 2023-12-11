package com.senac.coleta.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senac.coleta.api.entity.Estado;
import com.senac.coleta.api.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        List<Estado> estados = estadoRepository.findAll();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Integer estadoId) {
        return estadoRepository.findById(estadoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        Estado createdEstado = estadoRepository.saveAndFlush(estado);
        return ResponseEntity.ok(createdEstado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Integer estadoId, @RequestBody Estado estado) {
        if (!estadoRepository.existsById(estadoId)) {
            return ResponseEntity.notFound().build();
        }
        estado.setId(estadoId);
        Estado updatedEstado = estadoRepository.save(estado);
        return ResponseEntity.ok(updatedEstado);
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer estadoId) {
        if (!estadoRepository.existsById(estadoId)) {
            return ResponseEntity.notFound().build();
        }
        estadoRepository.deleteById(estadoId);
        return ResponseEntity.noContent().build();
    }
}