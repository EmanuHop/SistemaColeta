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

import com.senac.coleta.api.entity.Endereco;
import com.senac.coleta.api.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.findEnderecoById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@PathVariable Long usuarioId, @RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.saveOrUpdateEndereco(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PutMapping("/{enderecoId}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long enderecoId, @RequestBody Endereco enderecoDetails) {
        return enderecoService.findEnderecoById(enderecoId).map(endereco -> {
            endereco.setPlaceId(enderecoDetails.getPlaceId());
            endereco.setRua(enderecoDetails.getRua());
            endereco.setNumero(enderecoDetails.getNumero());
            endereco.setComplemento(enderecoDetails.getComplemento());
            endereco.setCep(enderecoDetails.getCep());
            endereco.setBairro(enderecoDetails.getBairro());
            endereco.setCidade(enderecoDetails.getCidade());
            endereco.setEstado(enderecoDetails.getEstado());
            Endereco updatedEndereco = enderecoService.saveOrUpdateEndereco(endereco);
            return ResponseEntity.ok(updatedEndereco);
        }).orElse(ResponseEntity.notFound().build());
    }
}
