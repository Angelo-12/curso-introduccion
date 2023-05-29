package com.example.cuentas.servicio.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.repository.CategoriaRepository;
import com.example.cuentas.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria save(Categoria c) {
		return categoriaRepository.save(c);
	}

	@Override
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}


}
