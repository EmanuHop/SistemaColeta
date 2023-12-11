package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.UsuarioEndereco;
import com.senac.coleta.api.repository.UsuarioEnderecoRepository;

@Service
public class UsuarioEnderecoService {

	@Autowired
    private final UsuarioEnderecoRepository usuarioEnderecoRepository;

    public UsuarioEnderecoService(UsuarioEnderecoRepository usuarioEnderecoRepository) {
        this.usuarioEnderecoRepository = usuarioEnderecoRepository;
    }

    public List<UsuarioEndereco> findAll() {
        return usuarioEnderecoRepository.findAll();
    }

    public Optional<UsuarioEndereco> findById(Long id) {
        return usuarioEnderecoRepository.findById(id);
    }

    public UsuarioEndereco save(UsuarioEndereco usuarioEndereco) {
        return usuarioEnderecoRepository.save(usuarioEndereco);
    }

    public UsuarioEndereco update(UsuarioEndereco usuarioEndereco) {
        return usuarioEnderecoRepository.save(usuarioEndereco);
    }

}
