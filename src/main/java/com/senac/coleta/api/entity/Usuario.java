package com.senac.coleta.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_email_login", length = 45)
    private String emailLogin;

    @Column(name = "usuario_nome", length = 250)
    private String nome;

    @Column(name = "usuario_telefone", length = 15)
    private String telefone;

    @Column(columnDefinition = "LONGBLOB", name = "usuario_foto")
    private byte[] foto;

    @Column(name = "usuario_cpf", length = 11)
    private String cpf;

    @Column(name = "usuario_cnpj", length = 15)
    private String cnpj;

    @Column(name = "usuario_senha", length = 45)
    private String senha;

    @Column(name = "usuario_status")
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_tipo_id")
    private UsuarioTipo usuarioTipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_endereco",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;
}
