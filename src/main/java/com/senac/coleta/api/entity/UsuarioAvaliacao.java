package com.senac.coleta.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario_avaliacao")
public class UsuarioAvaliacao {

    @Id
    @Column(name = "usuario_avaliacao_id")
    private Long id;

    @Column(name = "usuario_avaliacao_data", length = 45)
    private String data;

    @Column(name = "usuario_avaliacao_nota")
    private Integer nota;

    @Column(name = "usuario_avaliacao_comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "usuario_avaliacao_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_usuario_id_avaliador")
    private Usuario avaliador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_usuario_id_avaliado")
    private Usuario avaliado;
}
