package com.example.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cuentas.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
