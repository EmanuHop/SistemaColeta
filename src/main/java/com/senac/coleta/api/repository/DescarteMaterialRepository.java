package com.senac.coleta.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.coleta.api.entity.DescarteMaterial;

public interface DescarteMaterialRepository extends JpaRepository<DescarteMaterial, Long>{

	List<DescarteMaterial> findByQuantidadeGreaterThan(Double quantidade);
}
