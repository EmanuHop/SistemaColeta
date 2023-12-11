package com.senac.coleta.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.UsuarioEndereco;
import com.senac.coleta.api.service.UsuarioEnderecoService;

@RestController
@RequestMapping("/usuariosEnderecos")
public class UsuarioEnderecoController {

	@Autowired
    private final UsuarioEnderecoService usuarioEnderecoService;

    public UsuarioEnderecoController(UsuarioEnderecoService usuarioEnderecoService) {
        this.usuarioEnderecoService = usuarioEnderecoService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEndereco>> getAllUsuariosEnderecos() {
        List<UsuarioEndereco> usuariosEnderecos = usuarioEnderecoService.findAll();
        return ResponseEntity.ok(usuariosEnderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> getUsuarioEnderecoById(@PathVariable Long id) {
        return usuarioEnderecoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioEndereco> createUsuarioEndereco(@RequestBody UsuarioEndereco usuarioEndereco) {
        UsuarioEndereco novoUsuarioEndereco = usuarioEnderecoService.save(usuarioEndereco);
        return ResponseEntity.ok(novoUsuarioEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEndereco> updateUsuarioEndereco(@PathVariable Long id, @RequestBody UsuarioEndereco usuarioEnderecoDetails) {
        return usuarioEnderecoService.findById(id).map(usuarioEndereco -> {
            usuarioEndereco.setUsuario(usuarioEnderecoDetails.getUsuario());
            usuarioEndereco.setEndereco(usuarioEnderecoDetails.getEndereco());
            UsuarioEndereco updatedUsuarioEndereco = usuarioEnderecoService.update(usuarioEndereco);
            return ResponseEntity.ok(updatedUsuarioEndereco);
        }).orElse(ResponseEntity.notFound().build());
    }
}
