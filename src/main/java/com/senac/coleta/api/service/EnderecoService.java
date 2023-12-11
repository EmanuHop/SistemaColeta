package com.senac.coleta.api.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.Endereco;
import com.senac.coleta.api.entity.UsuarioEndereco;
import com.senac.coleta.api.repository.EnderecoRepository;
import com.senac.coleta.api.repository.UsuarioEnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
	private final EnderecoRepository enderecoRepository;
    @Autowired
    private final UsuarioEnderecoRepository usuarioEnderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, UsuarioEnderecoRepository usuarioEnderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        this.usuarioEnderecoRepository = usuarioEnderecoRepository;
    }

    public List<Endereco> findAllEnderecosByUsuarioId(Long usuarioId) {
        List<UsuarioEndereco> usuarioEnderecos = usuarioEnderecoRepository.findAllById(Collections.singleton(usuarioId));
        return usuarioEnderecos.stream()
                .map(UsuarioEndereco::getEndereco)
                .collect(Collectors.toList());
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveOrUpdateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
