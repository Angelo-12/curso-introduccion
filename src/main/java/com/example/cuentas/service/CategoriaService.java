package com.example.cuentas.service;

import java.util.List;
import java.util.Optional;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.model.Cuenta;

public interface CategoriaService {

	public List<Categoria> findAll();
	
	public Categoria save(Categoria c);
	
	public Optional<Categoria> findById(Long id);
	
	public void delete(Long id);
}
