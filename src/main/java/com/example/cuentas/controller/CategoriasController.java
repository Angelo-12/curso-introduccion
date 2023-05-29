package com.example.cuentas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.servicio.implementation.CategoriaServiceImp;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	private CategoriaServiceImp categoria;
	
	@GetMapping
	public List<Categoria>findAll(){
		return categoria.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Categoria> findById(@PathVariable("id") Long id ){
		return this.categoria.findById(id);
	}
	
	@PostMapping
	public Categoria save(@RequestBody Categoria categoria) {
		return this.categoria.save(categoria);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.categoria.delete(id);
	}
}
