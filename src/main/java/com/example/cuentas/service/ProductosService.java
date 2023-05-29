package com.example.cuentas.service;

import java.util.List;
import java.util.Optional;

import com.example.cuentas.model.Producto;

public interface ProductosService {

	public List<Producto> findAll();
	
	public Producto save(Producto p);
	
	public Optional<Producto> findById(Long id);
	
	public void delete(Long id);
}
