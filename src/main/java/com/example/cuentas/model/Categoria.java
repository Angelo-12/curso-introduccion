package com.example.cuentas.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Categoria de los productos")
@Table(name = "categoria")
@Entity
public class Categoria{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column
	private Long id;
	
	@Column(name = "categoria")
	@ApiModelProperty(value = "Categoria del producto")
	private String categoria;
	

	public Categoria() {
	}

	public Categoria(Long id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
