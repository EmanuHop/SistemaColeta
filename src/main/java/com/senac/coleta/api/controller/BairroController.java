package com.senac.coleta.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.Bairro;
import com.senac.coleta.api.service.BairroService;

@RestController
@RequestMapping("/bairros")
public class BairroController {

	@Autowired
    private final BairroService bairroService;

    public BairroController(BairroService bairroService) {
        this.bairroService = bairroService;
    }

    @GetMapping
    public ResponseEntity<List<Bairro>> getAllBairros() {
        return ResponseEntity.ok(bairroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bairro> getBairroById(@PathVariable Integer id) {
        Optional<Bairro> bairro = bairroService.findById(id);
        return bairro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bairro> createBairro(@RequestBody Bairro bairro) {
        Bairro novoBairro = bairroService.save(bairro);
        return ResponseEntity.ok(novoBairro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bairro> updateBairro(@PathVariable Integer id, @RequestBody Bairro bairro) {
        return bairroService.findById(id)
                .map(bairroExistente -> {
                    bairro.setId(id);
                    Bairro bairroAtualizado = bairroService.update(bairro);
                    return ResponseEntity.ok(bairroAtualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
