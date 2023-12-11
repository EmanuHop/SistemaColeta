package com.senac.coleta.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacao_id")
    private Long id;

    @Column(name = "notificacao_texto")
    private String texto;

    @Column(name = "notificacao_data")
    private LocalDateTime data;

    @Column(name = "notificacao_status")
    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_receptor_id", referencedColumnName = "usuario_id")
    private Usuario usuarioReceptor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_notificador_id", referencedColumnName = "usuario_id")
    private Usuario usuarioNotificador;
}

