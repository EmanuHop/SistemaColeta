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

import com.senac.coleta.api.entity.Cidade;
import com.senac.coleta.api.service.CidadeService;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> getAllCidades() {
        return ResponseEntity.ok(cidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable Integer id) {
        Optional<Cidade> cidade = cidadeService.findById(id);
        return cidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade) {
        Cidade novaCidade = cidadeService.save(cidade);
        return ResponseEntity.ok(novaCidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> updateCidade(@PathVariable Integer id, @RequestBody Cidade cidade) {
        return cidadeService.findById(id)
                .map(cidadeExistente -> {
                    cidade.setId(id);
                    Cidade cidadeAtualizada = cidadeService.update(cidade);
                    return ResponseEntity.ok(cidadeAtualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
