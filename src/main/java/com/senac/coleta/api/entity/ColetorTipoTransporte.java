package com.senac.coleta.api.entity;

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
@Table(name = "coletor_tipo_transporte")
public class ColetorTipoTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coletor_tipo_transporte_id")
    private Long id;

    @Column(name = "coletor_tipo_transporte_descricao")
    private String descricao;

    @Column(name = "coletor_tipo_transporte_capacidade")
    private int capacidade;

    @Column(name = "coletor_tipo_transporte_status")
    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coletor_id")
    private Coletor coletor;
}
