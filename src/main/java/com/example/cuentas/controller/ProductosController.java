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

import com.example.cuentas.model.Producto;
import com.example.cuentas.servicio.implementation.ProductosServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductosServiceImp producto;
	
	@ApiOperation(value = "Buscar todos los productos",notes = "Devuelve un listado con todos los productos")
	@GetMapping
	public List<Producto> findAll(){
		return producto.findAll();
	}
	
	@ApiOperation(value = "Buscar por id",notes = "Devuelve un producto mediante un id")
	@GetMapping("/{id}")
	public Optional<Producto> findById(@PathVariable("id")Long id) {
		return producto.findById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Agregar producto",notes = "Agrega un nuevo producto")
	public Producto save(@RequestBody Producto p) {
		return producto.save(p);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar un producto",notes = "Elimina un producto mediante su id")
	public void delete(@PathVariable("id")Long id) {
		producto.delete(id);
	}
	
}
