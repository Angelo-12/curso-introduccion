package com.example.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cuentas.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	@Query(value = "select* from pais where nombre_pais LIKE %?%",nativeQuery = true)
	Pais getPais(@Param("nombre")String nombre);
}
