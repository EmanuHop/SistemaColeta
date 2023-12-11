 package com.senac.coleta.api.entity;

import jakarta.persistence.CascadeType;
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
@Table(name = "tipo_material_descarte")
public class TipoMaterialDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_material_descarte_id")
    private Long id;

    @Column(name = "tipo_material_descarte_nome")
    private String nome;

    @Column(name = "tipo_material_descarte_umedida")
    private String unidadeMedida;

    @Column(name = "material_coleta_status")
    private Integer status;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_tipo_id")
    private MaterialTipo materialTipo;

}
