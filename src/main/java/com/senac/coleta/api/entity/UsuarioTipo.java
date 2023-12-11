package com.senac.coleta.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario_tipo")
public class UsuarioTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_tipo_id")
    private Long id;

    @Column(name = "usuario_tipo_descricao", length = 45)
    private String descricao;

    @Column(name = "usuario_tipo_status", length = 45)
    private String status;
}