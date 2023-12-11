package com.senac.coleta.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.DescarteMaterial;
import com.senac.coleta.api.service.DescarteMaterialService;

@RestController
@RequestMapping("/descarteMaterial")
public class DescarteMaterialController {

    @Autowired
    private DescarteMaterialService service;
    
    @GetMapping("/list")
    public ResponseEntity<List<DescarteMaterial>> findAll() {
        List<DescarteMaterial> descarteMateriais = service.listAll();
        return ResponseEntity.ok(descarteMateriais);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DescarteMaterial> getDescarteMaterial(@PathVariable Long id) {
        Optional<DescarteMaterial> descarteMaterial = service.findById(id);
        if(descarteMaterial.isPresent()) {
	    	return ResponseEntity.ok(descarteMaterial.get());
	    } else {
	    	return ResponseEntity.notFound().build();
	    }
    }
    
    @PostMapping
    public ResponseEntity<DescarteMaterial> insert(@RequestBody DescarteMaterial newDescarteMaterial) {
        DescarteMaterial descarteMaterial = service.save(newDescarteMaterial);
        return ResponseEntity.ok(descarteMaterial);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DescarteMaterial> replace(@RequestBody DescarteMaterial newDescarteMaterial, @PathVariable Long id) {
        DescarteMaterial descarteMaterial = service.update(newDescarteMaterial, id);
        return descarteMaterial != null ? ResponseEntity.ok(descarteMaterial) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/listarDescartesQuantidade")	
    public ResponseEntity<List<DescarteMaterial>> listarDescartesPorQuantidade(@RequestParam Double quantidade) {
        List<DescarteMaterial> descartes = service.listarDescartesPorQuantidade(quantidade);
        if(descartes != null) {
        	return ResponseEntity.ok(descartes);
        } else {
        	return ResponseEntity.notFound().build();
        }
    }
}