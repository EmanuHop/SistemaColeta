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
@Table(name = "material_tipo")
public class MaterialTipo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_tipo_id")
	private Long id;
	
	@Column(name = "material_tipo_descricao")
	private String descricao;
	
	@Column(name = "material_tipo_status")
	private int status;
}
