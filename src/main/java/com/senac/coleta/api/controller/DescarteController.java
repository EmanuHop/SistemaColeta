package com.senac.coleta.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.Descarte;
import com.senac.coleta.api.service.DescarteService;

@RestController
@RequestMapping("/descartes")
public class DescarteController {

	@Autowired
	private DescarteService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Descarte>> findAll(){
		List<Descarte> descartes = service.listAll();
		return ResponseEntity.ok(descartes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Descarte> getDescarte(@PathVariable Long id) {
	    Optional<Descarte> descarte = service.findById(id);
	    if(descarte.isPresent()) {
	    	return ResponseEntity.ok(descarte.get());
	    } else {
	    	return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping
	public ResponseEntity<Descarte> insert(@RequestBody Descarte newDescarte) {
		Descarte descarte = service.save(newDescarte);
		if(descarte != null) {
			return ResponseEntity.ok(descarte);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Descarte> replace(@RequestBody Descarte newDescarte, @PathVariable Long id) {
		Descarte descarte = service.update(newDescarte, id);
		return descarte != null ? ResponseEntity.ok(descarte) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Descarte> delete(@PathVariable Long id) {
		Boolean resp = service.delete(id);
		if(resp) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
    @GetMapping("/listarDescartesMaisRecentes")
    public ResponseEntity<List<Descarte>> listarDescartesMaisRecentes() {
        List<Descarte> descartes = service.listarDescartesMaisRecentes();
        if(descartes != null) {
        	return ResponseEntity.ok(descartes);
        } else {
        	return ResponseEntity.notFound().build();
        }  
    }
    
    @GetMapping("/listarDescartesMaisAntigas")
    public ResponseEntity<List<Descarte>> listarDescartesMaisAntigas() {
        List<Descarte> descartes = service.listarDescartesMaisAntigas();
        if(descartes != null) {
        	return ResponseEntity.ok(descartes);
        } else {
        	return ResponseEntity.notFound().build();
        }
    }
}
