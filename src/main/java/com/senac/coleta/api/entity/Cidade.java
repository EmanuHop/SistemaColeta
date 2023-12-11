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
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "cidade_id")
	private Integer id;
	
	@Column(name= "cidade_nome")
	private String nome;
	
	@Column(name= "cidade_status")
	private String status;
	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_estado_id")
    private Estado estado;
}
