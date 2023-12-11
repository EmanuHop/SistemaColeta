package com.senac.coleta.api.controller;

import java.util.List;

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

import com.senac.coleta.api.entity.AcordoColeta;
import com.senac.coleta.api.service.AcordoColetaService;

@RestController
@RequestMapping(value = "/acordo")
public class AcordoColetaController {

	@Autowired
	private AcordoColetaService service;

	@GetMapping("/list")
	public ResponseEntity<List<AcordoColeta>> listAllAcordos(){
		List<AcordoColeta> acordos = service.listAll();
		return ResponseEntity.ok(acordos);
	}
	
	@PostMapping("/agendarColeta")
	public ResponseEntity<AcordoColeta> agendarColeta(@RequestBody AcordoColeta acordoColeta){
		AcordoColeta acordo = service.schedule(acordoColeta);
		if(acordo != null) {
			return ResponseEntity.ok(acordo);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	@PostMapping
	public ResponseEntity<AcordoColeta> addAcordo(@RequestBody AcordoColeta acordoColeta ) {
		AcordoColeta acordo = service.save(acordoColeta);
		if(acordo != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(acordo);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AcordoColeta> updateAcordo(@RequestBody AcordoColeta newAcordo, @PathVariable Long id) {
		AcordoColeta acordo = service.update(newAcordo, id);
		if(acordo != null) {
			return ResponseEntity.ok(acordo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AcordoColeta> deleteAcordo(@PathVariable Long id) {
		Boolean resp = service.delete(id);
		if(resp) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
