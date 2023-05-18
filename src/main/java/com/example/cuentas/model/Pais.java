package com.example.cuentas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPais;
	private String nombrePais;
	private int cantidadHabitantes;
	private String codigoPais;
	
	public Pais() {
	
	}
	public Pais(Long idPais, String nombrePais,int cantidadHabitantes ,String codigoPais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
		this.cantidadHabitantes=cantidadHabitantes;
		this.codigoPais = codigoPais;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public int getCantidadHabitantes() {
		return cantidadHabitantes;
	}
	public void setCantidadHabitantes(int cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	
}
