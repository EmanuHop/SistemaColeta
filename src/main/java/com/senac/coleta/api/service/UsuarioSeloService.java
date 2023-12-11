package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.UsuarioSelo;
import com.senac.coleta.api.repository.UsuarioSeloRepository;

@Service
public class UsuarioSeloService {

	@Autowired
    private final UsuarioSeloRepository usuarioSeloRepository;

    public UsuarioSeloService(UsuarioSeloRepository usuarioSeloRepository) {
        this.usuarioSeloRepository = usuarioSeloRepository;
    }

    public List<UsuarioSelo> findAll() {
        return usuarioSeloRepository.findAll();
    }

    public Optional<UsuarioSelo> findById(Long id) {
        return usuarioSeloRepository.findById(id);
    }

    public UsuarioSelo save(UsuarioSelo usuarioSelo) {
        return usuarioSeloRepository.save(usuarioSelo);
    }

    public void delete(Long id) {
        usuarioSeloRepository.deleteById(id);
    }
}
