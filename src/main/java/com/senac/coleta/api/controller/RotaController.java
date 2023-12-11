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
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.AcordoColeta;
import com.senac.coleta.api.entity.Rota;
import com.senac.coleta.api.service.RotaService;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaService service;

    @GetMapping("/list")
    public ResponseEntity<List<Rota>> findAll() {
        List<Rota> rotas = service.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> getRota(@PathVariable Integer id) {
        Optional<Rota> rota = service.findById(id);
        if(rota.isPresent()) {
	    	return ResponseEntity.ok(rota.get());
	    } else {
	    	return ResponseEntity.notFound().build();
	    }
    }

    @PostMapping
    public ResponseEntity<Rota> insert(@RequestBody Rota newRota) {
        Rota rota = service.save(newRota);
        return ResponseEntity.ok(rota);
    }
    
    @PostMapping("/cadastrarRota")
    public ResponseEntity<Rota> cadastrarRota(@RequestBody List<AcordoColeta> acordos){
        Rota rota = new Rota();
        rota.setInicio(null);
        rota.setOtimizada(1);
        rota.setEndereco(null);
        rota.setStatus("1");

        service.save(rota);

        Rota newRota = service.cadastrarRota(rota, acordos);
        return ResponseEntity.ok(newRota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> replace(@RequestBody Rota newRota, @PathVariable Integer id) {
        Rota rota = service.update(newRota, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
