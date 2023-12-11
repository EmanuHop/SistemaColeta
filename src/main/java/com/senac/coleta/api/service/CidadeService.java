package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.Cidade;
import com.senac.coleta.api.repository.CidadeRepository;


@Service
public class CidadeService {

	@Autowired
    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> findById(Integer id) {
        return cidadeRepository.findById(id);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade update(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
