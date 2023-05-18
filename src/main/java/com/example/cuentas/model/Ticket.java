package com.example.cuentas.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTicket;
	private String fechaCreacion;
	
	public Ticket() {
		
	}
	
	public Ticket(Long idTicket, String fechaCreacion) {
		super();
		this.idTicket = idTicket;
		this.fechaCreacion = fechaCreacion;
	}
	public Long getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	} 
	
}
