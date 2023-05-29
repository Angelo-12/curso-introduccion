package com.example.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuentas.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Long>{

}
