
package com.senac.coleta.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.coleta.api.entity.Notificacao;
import com.senac.coleta.api.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

	@Autowired
    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Notificacao>> getAllNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.findAll();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> getNotificacaoById(@PathVariable Long id) {
        return notificacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notificacao> createNotificacao(@RequestBody Notificacao notificacao) {
        Notificacao novaNotificacao = notificacaoService.save(notificacao);
        return ResponseEntity.ok(novaNotificacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> updateNotificacao(@PathVariable Long id, @RequestBody Notificacao notificacaoDetails) {
        return notificacaoService.findById(id).map(notificacao -> {
            notificacao.setTexto(notificacaoDetails.getTexto());
            notificacao.setData(notificacaoDetails.getData());
            notificacao.setStatus(notificacaoDetails.getStatus());
            notificacao.setUsuarioReceptor(notificacaoDetails.getUsuarioReceptor());
            notificacao.setUsuarioNotificador(notificacaoDetails.getUsuarioNotificador());
            Notificacao updatedNotificacao = notificacaoService.update(notificacao);
            return ResponseEntity.ok(updatedNotificacao);
        }).orElse(ResponseEntity.notFound().build());
    }
}

