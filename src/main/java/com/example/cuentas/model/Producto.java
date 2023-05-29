package com.example.cuentas.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "nombre")
	@ApiModelProperty(value = "Nombre del producto")
	private String nombre;
	
	@Column(name = "descripcion")
	@ApiModelProperty(value = "Descripcion del producto")
	private String descripcion;
	
	@Column(name = "precio")
	@ApiModelProperty(value = "Precio del producto")
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	@ApiModelProperty(value = "Categoria a la que pertenece el pruducto")
	private Categoria categoria;

	public Producto() {
	
	}

	public Producto(Long id, String nombre, String descripcion, Double precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
