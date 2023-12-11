package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.AcordoColeta;
import com.senac.coleta.api.entity.Rota;
import com.senac.coleta.api.entity.RotaTrajeto;
import com.senac.coleta.api.repository.RotaRepository;

import jakarta.transaction.Transactional;

@Service
public class RotaService {

    @Autowired private RotaRepository repository;
    @Autowired private RotaTrajetoService trajetoService;
    @Autowired private AcordoColetaService acordoService;

    public List<Rota> listAll() {
        return repository.findAll();
    }

    public Optional<Rota> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Rota save(Rota rota) {
        return repository.save(rota);
    }

    @Transactional
    public Rota update(Rota newRota, Integer id) {
        Optional<Rota> rotaOptional = findById(id);
        if(rotaOptional.isPresent()) {
        	Rota rota = rotaOptional.get();
            rota.setInicio(newRota.getInicio());
            rota.setOtimizada(newRota.getOtimizada());
            rota.setStatus(newRota.getStatus());
            rota.setEndereco(newRota.getEndereco());
            return save(rota);
        } else{
        	return null;
        }
    }

    public boolean delete(Integer id) {
        Optional<Rota> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> repository.delete(rota));
        return rotaOptional.isPresent();
    }

    @Transactional
    public Rota cadastrarRota(Rota rota, List<AcordoColeta> acordos) {
        for (int i = 0; i < acordos.size(); i++) {
            RotaTrajeto trajeto = new RotaTrajeto();
            trajeto.setAcordo(acordos.get(i));
            trajeto.setOrdem(i);
//            trajeto.setRota(rota);
            trajetoService.save(trajeto);
        }
        return this.findById(rota.getId()).orElse(null);
    }

}

