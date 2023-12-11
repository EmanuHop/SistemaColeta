package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.Bairro;
import com.senac.coleta.api.repository.BairroRepository;

@Service
public class BairroService {

	@Autowired
    private final BairroRepository bairroRepository;

    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Optional<Bairro> findById(Integer id) {
        return bairroRepository.findById(id);
    }
 
    public Bairro save(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public Bairro update(Bairro bairro) {
        return bairroRepository.save(bairro);
    }
}


