package com.senac.coleta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.coleta.api.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
