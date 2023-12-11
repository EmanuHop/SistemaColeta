package com.senac.coleta.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.Descarte;
import com.senac.coleta.api.repository.DescarteRepository;

import jakarta.transaction.Transactional;

@Service
public class DescarteService {

	@Autowired
	private DescarteRepository repository;
	
	public List<Descarte> listAll(){
		return repository.findAll();
	}
	
	public Optional<Descarte> findById(Long id){
		return repository.findById(id);
	}
	
	@Transactional
	public Descarte save(Descarte descarte) {
		return repository.save(descarte);
	}
	
	@Transactional
	public Descarte update(Descarte newDescarte, Long id) {
		Optional<Descarte> descarte = findById(id);
		if(descarte.isPresent()) {
			Descarte descarteUpdate = descarte.get();
			descarteUpdate.setData(newDescarte.getData());
			descarteUpdate.setDescartador(newDescarte.getDescartador());
			descarteUpdate.setDescartes(newDescarte.getDescartes());
			descarteUpdate.setEndereco(newDescarte.getEndereco());
			descarteUpdate.setTempoDisponivel(newDescarte.getTempoDisponivel());
			descarteUpdate.setStatus(newDescarte.getStatus());
			return save(descarteUpdate);
		} else {
			return null;
		}
	}
	
	@Transactional
	public Boolean delete(Long id) {
		Optional<Descarte> descarte = findById(id);
		if(descarte.isPresent()) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
    public List<Descarte> listarDescartesMaisRecentes() {
        return repository.findByTempoDisponivelGreaterThan(LocalDateTime.now());
    }
    
    public List<Descarte> listarDescartesMaisAntigas() {
        return repository.findByTempoDisponivelLessThan(LocalDateTime.now());
    }
}
