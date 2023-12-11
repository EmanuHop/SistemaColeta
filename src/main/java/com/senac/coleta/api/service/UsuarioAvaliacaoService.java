package com.senac.coleta.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.UsuarioAvaliacao;
import com.senac.coleta.api.repository.UsuarioAvaliacaoRepository;


@Service
public class UsuarioAvaliacaoService {

	@Autowired
    private final UsuarioAvaliacaoRepository repository;

    public UsuarioAvaliacaoService(UsuarioAvaliacaoRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioAvaliacao> findAll() {
        return repository.findAll();
    }

    public Optional<UsuarioAvaliacao> findById(Long id) {
        return repository.findById(id);
    }

    public UsuarioAvaliacao save(UsuarioAvaliacao usuarioAvaliacao) {
        return repository.save(usuarioAvaliacao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}