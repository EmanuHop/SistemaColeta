package com.senac.coleta.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.RotaTrajeto;
import com.senac.coleta.api.service.RotaTrajetoService;

@RestController
@RequestMapping("/rotaTrajetos")
public class RotaTrajetoController {

    @Autowired
    private RotaTrajetoService service;

    @GetMapping("/list")
    public ResponseEntity<List<RotaTrajeto>> findAll() {
        List<RotaTrajeto> rotaTrajetos = service.listAll();
        return ResponseEntity.ok(rotaTrajetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaTrajeto> getRotaTrajeto(@PathVariable Long id) {
        Optional<RotaTrajeto> rotaTrajeto = service.findById(id);
        return rotaTrajeto.isPresent() ? ResponseEntity.ok(rotaTrajeto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RotaTrajeto> insert(@RequestBody RotaTrajeto newRotaTrajeto) {
        RotaTrajeto rotaTrajeto = service.save(newRotaTrajeto);
        return ResponseEntity.ok(rotaTrajeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotaTrajeto> replace(@RequestBody RotaTrajeto newRotaTrajeto, @PathVariable Long id) {
        RotaTrajeto rotaTrajeto = service.update(newRotaTrajeto, id);
        return rotaTrajeto != null ? ResponseEntity.ok(rotaTrajeto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
