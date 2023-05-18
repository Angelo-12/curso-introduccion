package com.example.cuentas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuenta;
	private String numeroCuenta;
	private double saldo;
	
	public Cuenta() {
		super();
	}
	public Cuenta(Long idCuenta, String numeroCuenta, double saldo) {
		super();
		this.idCuenta = idCuenta;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	public Long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
}
