package com.senac.coleta.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rota")
public class Rota {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rota_id")
	private Integer id;
	
	@Column(name = "rota_inicio_time")
	private LocalDateTime inicio;
	
	@Column(name = "rota_otimizada", columnDefinition = "tinyint")
	private int otimizada;
	
	@Column(name = "rota_status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
//    @ManyToMany(mappedBy = "rotas")
//    private List<AcordoColeta> acordos;
	
//	@OneToMany(mappedBy = "rota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<RotaTrajeto> rotas;

	
}
