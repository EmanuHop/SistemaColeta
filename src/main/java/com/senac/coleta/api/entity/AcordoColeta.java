package com.senac.coleta.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "acordo_coleta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AcordoColeta {

	@Id
	@Column(name = "acordo_coleta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "acordo_coleta_data_solicitacao")
	private LocalDateTime DataSolicitacao;
	
	@Column(name = "acordo_coleta_data_coleta")
	private LocalDateTime DataColeta;
	
	@Column(name = "acordo_coleta_status")
	private int status;

	@OneToOne
	@JoinColumn(name = "coletor_id")
	private Coletor coletor;
	
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "rota_trajeto",
//            joinColumns = @JoinColumn(name = "acordo_coleta_id"),
//            inverseJoinColumns = @JoinColumn(name = "rota_id")
//    )
//    private List<Rota> rotas;
	
	@OneToMany(mappedBy = "acordoColeta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DescarteMaterial> coletas;
	
	
	public List<DescarteMaterial> getColetas() {
		return coletas;
	}
	
	public void setColetas(List<DescarteMaterial> coletas) {
		this.coletas = coletas;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDataSolicitacao() {
		return DataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		DataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getDataColeta() {
		return DataColeta;
	}

	public void setDataColeta(LocalDateTime dataColeta) {
		DataColeta = dataColeta;
	}

	public Coletor getColetor() {
		return coletor;
	}

	public void setColetor(Coletor coletor) {
		this.coletor = coletor;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
