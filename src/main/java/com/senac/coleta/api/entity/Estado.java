package com.senac.coleta.api.entity;

import java.math.BigInteger;

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
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estado_id")
	private Integer id;
	
	@Column(name = "estado_nome", unique = true)
	private String nome;
	
	@Column(name = "estado_sigla")
	private String sigla;
	
	@Column(name = "estado_status")
	private int status;
}
