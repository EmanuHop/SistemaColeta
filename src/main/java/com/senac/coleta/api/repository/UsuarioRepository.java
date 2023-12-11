package com.senac.coleta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.coleta.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
