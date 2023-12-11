package com.senac.coleta.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bairro_id")
    private Integer id;

    @Column(name = "bairro_nome", length = 45)
    private String nome;

    @Column(name = "bairro_status", length = 45)
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_cidade_id")
    private Cidade cidade;

}
