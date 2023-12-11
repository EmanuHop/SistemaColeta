package com.senac.coleta.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "endereco")
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;
	
	@Column(name = "endereco_place_id")
	private String placeId;
	
	@Column(name = "endereco_rua")
	private String rua;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_cep")
	private String cep;
	
	@OneToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;
	
	@OneToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
}
