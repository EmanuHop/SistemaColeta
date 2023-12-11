package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.RotaTrajeto;
import com.senac.coleta.api.repository.RotaTrajetoRepository;

import jakarta.transaction.Transactional;

@Service
public class RotaTrajetoService {

    @Autowired
    private RotaTrajetoRepository repository;

    public List<RotaTrajeto> listAll() {
        return repository.findAll();
    }

    public Optional<RotaTrajeto> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public RotaTrajeto save(RotaTrajeto rotaTrajeto) {
        return repository.save(rotaTrajeto);
    }

    @Transactional
    public RotaTrajeto update(RotaTrajeto newRotaTrajeto, Long id) {
        Optional<RotaTrajeto> rotaTrajetoOptional = findById(id);
        if(rotaTrajetoOptional.isPresent()) {
        	RotaTrajeto rotaTrajeto = rotaTrajetoOptional.get();
            rotaTrajeto.setOrdem(newRotaTrajeto.getOrdem());
//            rotaTrajeto.setRota(newRotaTrajeto.getRota());
            rotaTrajeto.setAcordo(newRotaTrajeto.getAcordo());
            return save(rotaTrajeto);
        } else {
        	return null;
        }
    }

    public boolean delete(Long id) {
        Optional<RotaTrajeto> rotaTrajetoOptional = findById(id);
        rotaTrajetoOptional.ifPresent(rotaTrajeto -> repository.delete(rotaTrajeto));
        return rotaTrajetoOptional.isPresent();
    }
}