package com.example.cuentas;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cuentas.model.Categoria;
import com.example.cuentas.repository.CategoriaRepository;
import com.example.cuentas.servicio.implementation.CategoriaServiceImp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoriasControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private CategoriaServiceImp categoriaService;
	
	@Test
	void findAll() {
		Categoria c= new Categoria(1L,"Electrodomesticos");
		Categoria c1= new Categoria(2L,"Linea Blanca");
		
		List<Categoria>categorias= new ArrayList<Categoria>();
		
		categorias.add(c);
		categorias.add(c1);
		
		when(categoriaService.findAll()).thenReturn(categorias);
		
		List<Categoria>categoriasResult= categoriaRepository.findAll();
		
		 assertThat(categoriasResult.size()).isEqualTo(2);
	     assertThat(categoriasResult.get(0).getCategoria()).isEqualTo(c.getCategoria());
	     assertThat(categoriasResult.get(1).getCategoria()).isEqualTo(c1.getCategoria());
		
	}
	
	@Test
	void getById() throws Exception {
		Categoria categoria= new Categoria();
		categoria.setId(1L);
		categoria.setCategoria("Lacteos");
		
		
		
		 when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
		    mockMvc.perform(get("/categorias/{id}", 1L)).andExpect(status().isOk())
		        .andExpect(jsonPath("$.id").value(1L))
		        .andExpect(jsonPath("$.categoria").value(categoria.getCategoria()))
		        .andDo(print());
	}
	
	@Test
	void save() {
		Categoria cat= new Categoria();
		cat.setId(1L);
		cat.setCategoria("Pastas");;
		when(categoriaRepository.save(any(Categoria.class))).thenReturn(cat);
		
		assertNotNull(categoriaService.save(cat));
	}
	
	@Test
	void delete() {
		doNothing().when(categoriaRepository).deleteById(anyLong());
		categoriaService.delete(1l);
	}
	
}
