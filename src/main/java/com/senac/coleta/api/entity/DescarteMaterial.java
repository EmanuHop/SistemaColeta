package com.senac.coleta.api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "descarte_material")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DescarteMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descarte_material_id")
    private Long id;

    @Column(name = "descarte_material_quantidade")
    private Double quantidade;

    @Column(name = "descarte_material_status_coleta")
    private Integer statusColeta;

    @Column(name = "descarte_material_status")
    private int status;

    @Column(name = "descarte_material_preco")
    private Double preco;

    @Column(name = "descarte_material_imposto")
    private Double imposto;

    @OneToOne
    @JoinColumn(name = "material_coleta_id")
    private TipoMaterialDescarte tipoMaterialDescarte;
    
    @ManyToOne()
    @JoinColumn(name = "descarte_id")
    //@JsonBackReference
    private Descarte descarte;

    @ManyToOne
    @JoinColumn(name = "acordo_coleta_id")
    //@JsonBackReference
    private AcordoColeta acordoColeta;
}
