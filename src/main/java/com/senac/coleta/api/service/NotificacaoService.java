package com.senac.coleta.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.coleta.api.entity.Notificacao;
import com.senac.coleta.api.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

	@Autowired
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> findById(Long id) {
        return notificacaoRepository.findById(id);
    }

    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao update(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }
}
