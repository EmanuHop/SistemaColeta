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

import com.senac.coleta.api.entity.UsuarioAvaliacao;
import com.senac.coleta.api.service.UsuarioAvaliacaoService;

@RestController
@RequestMapping("/usuarioAvaliacao")
public class UsuarioAvaliacaoController {

	@Autowired
    private final UsuarioAvaliacaoService service;

    public UsuarioAvaliacaoController(UsuarioAvaliacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioAvaliacao> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAvaliacao> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioAvaliacao create(@RequestBody UsuarioAvaliacao usuarioAvaliacao) {
        return service.save(usuarioAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAvaliacao> update(@PathVariable Long id, @RequestBody UsuarioAvaliacao usuarioAvaliacao) {
        return service.findById(id)
                .map(existingUser -> {
                    usuarioAvaliacao.setId(id);
                    return ResponseEntity.ok(service.save(usuarioAvaliacao));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(usuarioAvaliacao -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}