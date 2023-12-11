package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.AcordoColeta;
import com.senac.coleta.api.entity.DescarteMaterial;
import com.senac.coleta.api.repository.DescarteMaterialRepository;

import jakarta.transaction.Transactional;

@Service
public class DescarteMaterialService {

    @Autowired
    private DescarteMaterialRepository repository;

    public List<DescarteMaterial> listAll() {
        return repository.findAll();
    }

    public Optional<DescarteMaterial> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public DescarteMaterial save(DescarteMaterial descarteMaterial) {
        return repository.save(descarteMaterial);
    }

    @Transactional
    public DescarteMaterial update(DescarteMaterial newDescarteMaterial, Long id) {
        Optional<DescarteMaterial> descarteMaterialOptional = findById(id);
        if(descarteMaterialOptional.isPresent()) {
        	DescarteMaterial descarteMaterial = descarteMaterialOptional.get();
        	descarteMaterial.setQuantidade(newDescarteMaterial.getQuantidade());
        	descarteMaterial.setStatusColeta(newDescarteMaterial.getStatusColeta());
        	descarteMaterial.setStatus(newDescarteMaterial.getStatus());
        	descarteMaterial.setPreco(newDescarteMaterial.getPreco());
        	descarteMaterial.setImposto(newDescarteMaterial.getImposto());
        	descarteMaterial.setTipoMaterialDescarte(newDescarteMaterial.getTipoMaterialDescarte());
        	descarteMaterial.setDescarte(newDescarteMaterial.getDescarte());
        	descarteMaterial.setAcordoColeta(newDescarteMaterial.getAcordoColeta());
        	return save(descarteMaterial);
        } else {
        	return null;
        }

    }

    @Transactional
    public boolean delete(Long id) {
        Optional<DescarteMaterial> descarteMaterialOptional = findById(id);
        descarteMaterialOptional.ifPresent(descarteMaterial -> repository.delete(descarteMaterial));
        return descarteMaterialOptional.isPresent();
    }
    
    @Transactional
	public void vincularMaterial(AcordoColeta acordo) {
		acordo.getColetas().forEach(descarte -> {
			descarte.setAcordoColeta(acordo);
			this.save(descarte);
		});
	}
    
    public List<DescarteMaterial> listarDescartesPorQuantidade(Double quantidade) {
        return repository.findByQuantidadeGreaterThan(quantidade);
    }
}
