package com.senac.coleta.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "descarte")
public class Descarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descarte_id")
    private Long id;

    @Column(name = "descarte_data")
    private LocalDateTime data;

    @Column(name = "descarte_status")
    private Integer status;

    @Column(name = "descarte_tempo_disponivel")
    private LocalDateTime tempoDisponivel;

    @OneToOne
    @JoinColumn(name = "descartador_id")
    private Descartador descartador;
    
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    @OneToMany(mappedBy = "descarte", fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<DescarteMaterial> descartes;
}