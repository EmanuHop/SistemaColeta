package com.senac.coleta.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "coletor_material_coleta")
public class ColetorMaterialColeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coletor_material_coleta_id")
	private Long id;
	
	@Column(name = "coletor_material_coleta_status")
	private int status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coletor_id")
	private Coletor coletor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_material_descarte_id")
	private TipoMaterialDescarte tipoMaterialDescarte;
}
