package com.senac.coleta.api.controller;

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

import com.senac.coleta.api.entity.Selo;
import com.senac.coleta.api.service.SeloService;

@RestController
@RequestMapping("/selos")
public class SeloController {

    @Autowired
    private SeloService seloService;

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok(seloService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(seloService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Selo selo){
        return ResponseEntity.ok(seloService.salvar(selo));
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody Selo selo){
        return ResponseEntity.ok(seloService.atualizar(selo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        seloService.deletar(id);
        return ResponseEntity.ok().build();
    }

}