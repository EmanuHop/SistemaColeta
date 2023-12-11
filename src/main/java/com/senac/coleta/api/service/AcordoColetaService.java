package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.AcordoColeta;
import com.senac.coleta.api.repository.AcordoColetaRepository;

import jakarta.transaction.Transactional;

@Service 
public class AcordoColetaService {

	@Autowired
	private AcordoColetaRepository repository;
	@Autowired
	private DescarteMaterialService descarteMaterialService;
	
	public List<AcordoColeta> listAll(){
		return repository.findAll();
	}
	
	public Optional<AcordoColeta> findById(Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public AcordoColeta save(AcordoColeta acordo) {
		return repository.save(acordo);
	}
	
	@Transactional
	public AcordoColeta update(AcordoColeta newAcordo, Long id){
		Optional<AcordoColeta> acordo = findById(id);
		
		if(acordo.isPresent()) {
			AcordoColeta acordoAtualizado = acordo.get();
			acordoAtualizado.setDataColeta(newAcordo.getDataColeta());
			acordoAtualizado.setDataSolicitacao(newAcordo.getDataSolicitacao());
			return save(acordoAtualizado);
		} else {
			return null;
		}
	}
	
	@Transactional
	public Boolean delete(Long id) {
		Optional<AcordoColeta> acordo = findById(id);
		if(acordo.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return null;
		}
	}

	@Transactional
	public AcordoColeta schedule(AcordoColeta acordoColeta) {
		AcordoColeta acordo = repository.save(acordoColeta);
		descarteMaterialService.vincularMaterial(acordo);
		return acordo;
	}
}
