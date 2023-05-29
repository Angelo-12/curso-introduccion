package com.example.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuentas.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
