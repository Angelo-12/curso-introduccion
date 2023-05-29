package com.example.cuentas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.model.Producto;

public class Datos {
	
	public static Optional<Producto> crearProducto04(){
		/*Categoria c = new Categoria();
		c.setId(4L);
		c.setCategoria("Lacteo");
		Producto p = new Producto();
		p.setId(4L);
		p.setNombre("Nutrileche");
		p.setPrecio(24.00);
		p.setDescripcion("Leche Nutrileche de 1 litro");
		p.setCategoria(c);*/
		return Optional.of(new Producto());
	}
	
	public static Optional<Categoria> getCategorias(){
		Categoria categoria= new Categoria();
		
		categoria= new Categoria();
		categoria.setId(1L);
		categoria.setCategoria("Accesorios para el hogar");
		
		return Optional.of(categoria);
	}
}
