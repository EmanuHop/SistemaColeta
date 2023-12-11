package com.senac.coleta.api.controller;

import java.util.List;

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

import com.senac.coleta.api.entity.UsuarioSelo;
import com.senac.coleta.api.service.UsuarioSeloService;

@RestController
@RequestMapping("/usuarioSelos")
public class UsuarioSeloController {

	@Autowired
    private final UsuarioSeloService usuarioSeloService;

    public UsuarioSeloController(UsuarioSeloService usuarioSeloService) {
        this.usuarioSeloService = usuarioSeloService;
    }

    @GetMapping
    public List<UsuarioSelo> getAll() {
        return usuarioSeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSelo> getById(@PathVariable Long id) {
        return usuarioSeloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioSelo create(@RequestBody UsuarioSelo usuarioSelo) {
        return usuarioSeloService.save(usuarioSelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSelo> update(@PathVariable Long id, @RequestBody UsuarioSelo usuarioSelo) {
        return usuarioSeloService.findById(id)
                .map(existingUsuarioSelo -> {
                    usuarioSelo.setId(id);
                    return ResponseEntity.ok(usuarioSeloService.save(usuarioSelo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!usuarioSeloService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioSeloService.delete(id);
        return ResponseEntity.ok().build();
    }
}
