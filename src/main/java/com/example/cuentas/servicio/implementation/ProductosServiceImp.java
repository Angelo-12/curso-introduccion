package com.example.cuentas.servicio.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuentas.model.Producto;
import com.example.cuentas.repository.ProductosRepository;
import com.example.cuentas.service.ProductosService;

@Service
public class ProductosServiceImp implements ProductosService{

	@Autowired
	private ProductosRepository productosRepository;
	
	@Override
	public List<Producto> findAll() {
		return productosRepository.findAll();
	}

	@Override
	public Producto save(Producto p) {
		return productosRepository.save(p);
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return productosRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		productosRepository.deleteById(id);
	}

}
