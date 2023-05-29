package com.example.cuentas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.model.Producto;
import com.example.cuentas.repository.ProductosRepository;
import com.example.cuentas.servicio.implementation.ProductosServiceImp;

@ExtendWith(MockitoExtension.class)
public class ProductosControllerTest {

	@Mock
	private ProductosRepository productosRepository;

	@InjectMocks
	private ProductosServiceImp productosService;

	@Test
	void save() {
		Categoria cat = new Categoria();
		cat.setId(1L);
		cat.setCategoria("Bebida");
		Producto producto = new Producto();
		producto.setId(1L);
		producto.setNombre("Coca-cola");
		producto.setPrecio(20.00);
		producto.setDescripcion("Bebida saborizante 600 ml.");
		producto.setCategoria(cat);

		when(productosRepository.save(any(Producto.class))).thenReturn(producto);
		assertNotNull(productosService.save(producto));
	}
	
	@Test
	void findAll() {
		Categoria cat = new Categoria();
		cat.setId(1L);
		cat.setCategoria("Bebida");
		Producto producto = new Producto();
		producto.setId(1L);
		producto.setNombre("Coca-cola");
		producto.setPrecio(20.00);
		producto.setDescripcion("Bebida oscura 600 ml.");
		producto.setCategoria(cat);
		
		Producto producto1= new Producto();
		producto.setId(1L);
		producto.setNombre("Pepsi");
		producto.setPrecio(17.00);
		producto.setDescripcion("Bebida oscura 600 ml.");
		producto.setCategoria(cat);
		
		List<Producto>productos= new ArrayList<Producto>();
		
		productos.add(producto);
		productos.add(producto1);
		
		when(productosService.findAll()).thenReturn(productos);
		
		List<Producto>productosResult= productosRepository.findAll();
		
		 assertThat(productosResult.size()).isEqualTo(2);
	     assertThat(productosResult.get(0).getCategoria()).isEqualTo(producto.getCategoria());
	     assertThat(productosResult.get(1).getCategoria()).isEqualTo(producto1.getCategoria());
		
	}
	
	@Test
	void delete() {
		doNothing().when(productosRepository).deleteById(anyLong());
		productosService.delete(1l);
	}

}
