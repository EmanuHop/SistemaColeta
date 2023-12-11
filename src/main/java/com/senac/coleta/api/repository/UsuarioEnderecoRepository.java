package com.senac.coleta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.coleta.api.entity.UsuarioEndereco;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEndereco, Long> {

}
